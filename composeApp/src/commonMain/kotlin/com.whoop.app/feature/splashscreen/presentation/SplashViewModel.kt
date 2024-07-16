package com.whoop.app.feature.splashscreen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.whoop.app.core.local.LocalDataManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SplashViewModel(
    private val localData: LocalDataManager
) : ViewModel() {
    private val _checkBoardingStatus: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val checkBoardingStatus = _checkBoardingStatus.asStateFlow()

    init {
        boardingStatus()
    }

    private fun boardingStatus() = viewModelScope.launch {
        _checkBoardingStatus.update { localData.getData().boardingPref.isNotEmpty() }
    }
}