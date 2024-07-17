package com.whoop.app

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.mmk.kmpnotifier.notification.NotifierManager
import com.whoop.app.design.theme.AppTheme
import com.whoop.app.di.appModule
import com.whoop.app.navigation.boarding.BoardingNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@OptIn(ExperimentalAnimationApi::class)
@Composable
@Preview
fun App() = AppTheme {
    KoinApplication(application = {
        modules(appModule())
    }) {
        val navController = rememberNavController()
        BoardingNavGraph(navController = navController)
    }
}
