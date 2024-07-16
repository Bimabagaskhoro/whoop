package com.whoop.app.feature.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.whoop.app.design.component.BaseScreen

@Composable
fun HomeScreen() {
    BaseScreen(
        title = "",
        navigateBack = {},
        rightIcon = {},
        leftIcon = {}
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .background(color = MaterialTheme.colorScheme.surface),
        ) {

        }
    }
}
