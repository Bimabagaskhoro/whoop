package com.whoop.app.feature.splashscreen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.whoop.app.core.base.utils.UiState
import com.whoop.app.core.base.utils.asUiState
import com.whoop.app.core.local.LocalDataManager
import com.whoop.app.feature.splashscreen.core.model.SplashMapper.toSplashUi
import com.whoop.app.feature.splashscreen.core.model.SplashUiModel
import com.whoop.app.feature.splashscreen.core.repository.SplashRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SplashViewModel(
    private val repository: SplashRepository,
    private val localData: LocalDataManager
) : ViewModel() {
    private val _checkBoardingStatus: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val checkBoardingStatus = _checkBoardingStatus.asStateFlow()

    private val _checkGoogleSignIn: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val checkGoogleSignIn = _checkGoogleSignIn.asStateFlow()

    private val _uiState = MutableStateFlow<UiState<SplashUiModel>>(UiState.Default)
    val uiState = _uiState.asStateFlow()

    init {
        getSplashData()
        boardingStatus()
        googleSignIn()
    }

    private fun getSplashData() = viewModelScope.launch {
        _uiState.asUiState {
            repository.getSplash().toSplashUi()
        }
    }
    private fun boardingStatus() = viewModelScope.launch {
        _checkBoardingStatus.update { localData.getData().boardingPref.isNotEmpty() }
    }

    private fun googleSignIn() = viewModelScope.launch {
        _checkGoogleSignIn.update { localData.getToken().isNotEmpty() }
    }
}
