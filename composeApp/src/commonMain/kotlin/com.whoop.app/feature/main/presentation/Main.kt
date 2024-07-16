package com.whoop.app.feature.main.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.whoop.app.navigation.main.MainSections

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val tabs = remember { MainSections.entries.toTypedArray() }

}