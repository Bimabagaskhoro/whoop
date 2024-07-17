package com.whoop.app.feature.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mmk.kmpauth.google.GoogleAuthCredentials
import com.mmk.kmpauth.google.GoogleAuthProvider
import com.whoop.app.core.base.utils.UiState
import com.whoop.app.core.base.utils.asUiState
import com.whoop.app.core.local.LocalDataManager
import com.whoop.app.core.local.LocalUserModel
import com.whoop.app.utils.UtilsConstant.SERVER_ID
import com.whoop.app.utils.randomString
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val localData: LocalDataManager
) : ViewModel() {
    private val googleToken =MutableStateFlow(false)
    private val anonymous = MutableStateFlow(false)

    private val _initGoogleAuthProvider = MutableStateFlow(false)
    val initGoogleAuthProvider = _initGoogleAuthProvider.asStateFlow()

    private val _uiState = MutableStateFlow<UiState<Boolean>>(UiState.Default)
    val uiState = _uiState.asStateFlow()

    init {
        googleAuthProvider()
    }

    private fun googleAuthProvider() = viewModelScope.launch {
        GoogleAuthProvider.create(
            credentials = GoogleAuthCredentials(
                serverId = SERVER_ID
            )
        )
        _initGoogleAuthProvider.update { true }
    }

    fun uiState() = viewModelScope.launch {
        _uiState.asUiState {
            googleToken.value || anonymous.value
        }
    }

    fun saveToken(
        idToken: String? = "",
        accessToken: String? = "",
        displayName: String? = "",
        profilePicUrl: String? = "",
    ) = viewModelScope.launch {
        val data = LocalUserModel(
            idToken = idToken ?: randomString(),
            accessToken = accessToken ?: randomString(),
            displayName = displayName.orEmpty(),
            profilePicUrl = profilePicUrl.orEmpty()
        )
        localData.saveTokenAuth(data)
    }

    fun googleToken() = viewModelScope.launch {
        googleToken.update {
            localData.getTokenAuth().idToken.isNotEmpty() && localData.getTokenAuth().accessToken.isNotEmpty()
        }
    }

    fun anonymousToken() = viewModelScope.launch {
        anonymous.update { randomString().isNotEmpty() }
    }

}