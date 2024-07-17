package com.whoop.app.feature.boarding.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.whoop.app.core.base.utils.UiState
import com.whoop.app.core.base.utils.asUiState
import com.whoop.app.core.local.LocalDataManager
import com.whoop.app.core.local.LocalPrefModel
import com.whoop.app.feature.boarding.core.model.BoardingMapper.toBoardingUi
import com.whoop.app.feature.boarding.core.model.BoardingUiModel
import com.whoop.app.feature.boarding.core.repository.BoardingRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BoardViewModel(
    private val repository: BoardingRepository,
    private val localData: LocalDataManager
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<BoardingUiModel>>>(UiState.Default)
    val uiState = _uiState.asStateFlow()

    private val _checkGoogleSignIn: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val checkGoogleSignIn = _checkGoogleSignIn.asStateFlow()

    init {
        getBoardingData()
        googleSignIn()
    }

    private fun getBoardingData() = viewModelScope.launch {
        _uiState.asUiState {
            repository.getBoarding().toBoardingUi()
        }
    }

    fun saveBoarding(boardingPref: String) = viewModelScope.launch {
        val data = LocalPrefModel(boardingPref = boardingPref)
        localData.saveData(data)
    }

    private fun googleSignIn() = viewModelScope.launch {
        _checkGoogleSignIn.update {
            localData.getTokenAuth().idToken.isNotEmpty() && localData.getTokenAuth().accessToken.isNotEmpty()
        }
    }
}
