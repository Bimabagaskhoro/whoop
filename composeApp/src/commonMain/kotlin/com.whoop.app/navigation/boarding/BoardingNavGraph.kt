package com.whoop.app.navigation.boarding

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.whoop.app.feature.main.presentation.MainScreen
import com.whoop.app.feature.onboard.presentation.BoardingScreen
import com.whoop.app.feature.splashscreen.presentation.Splashscreen
import com.whoop.app.navigation.utils.DestinationsConstant.BOARDING_SCREEN
import com.whoop.app.navigation.utils.DestinationsConstant.MAIN_SCREEN
import com.whoop.app.navigation.utils.DestinationsConstant.SPLASHSCREEN

@ExperimentalAnimationApi
@Composable
fun BoardingNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    boardingAction: BoardingAction = BoardingAction(navController),
    startDestination: String = SPLASHSCREEN,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = SPLASHSCREEN) {
            Splashscreen (
                openBoarding = boardingAction.openBoarding,
                openMain = boardingAction.openMain
            )
        }

        composable(route = MAIN_SCREEN) {
            MainScreen()
        }
        composable(BOARDING_SCREEN) {
            BoardingScreen(
                openMainFromBoarding = boardingAction.openMainFromBoarding
            )
        }
    }
}