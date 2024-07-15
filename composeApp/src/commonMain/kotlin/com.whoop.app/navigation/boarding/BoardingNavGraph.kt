package com.whoop.app.navigation.boarding

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
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

    }
}