package com.whoop.app

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.whoop.app.di.appModule
import com.whoop.app.navigation.boarding.BoardingNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@OptIn(ExperimentalAnimationApi::class)
@Composable
@Preview
fun App() = MaterialTheme {
    KoinApplication(application = {
        modules(appModule())
    }) {
        val navController = rememberNavController()
        BoardingNavGraph(navController = navController)
    }
}
