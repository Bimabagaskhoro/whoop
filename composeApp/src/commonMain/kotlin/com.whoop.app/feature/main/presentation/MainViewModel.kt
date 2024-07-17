package com.whoop.app.feature.main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(
) : ViewModel() {

    init {
        initGetNotificationToken()
    }

    private fun initGetNotificationToken() = viewModelScope.launch {

    }
}