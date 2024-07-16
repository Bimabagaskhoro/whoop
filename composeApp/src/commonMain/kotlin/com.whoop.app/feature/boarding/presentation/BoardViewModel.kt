package com.whoop.app.feature.boarding.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.whoop.app.core.base.utils.UiState
import com.whoop.app.core.base.utils.asUiState
import com.whoop.app.core.local.LocalDataManager
import com.whoop.app.core.local.LocalDataModel
import com.whoop.app.feature.boarding.core.model.BoardingUiModel
import com.whoop.app.feature.boarding.core.model.dataBoardingUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BoardViewModel(
    private val localData: LocalDataManager
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<BoardingUiModel>>>(UiState.Default)
    val uiState = _uiState.asStateFlow()

    init {
        getBoardingData()
    }

    private fun getBoardingData() = viewModelScope.launch {
        _uiState.asUiState {
            dataBoardingUiModel
        }
    }

    fun saveBoarding(boardingPref: String) = viewModelScope.launch {
        val data = LocalDataModel(boardingPref = boardingPref)
        localData.saveData(data)
    }
}