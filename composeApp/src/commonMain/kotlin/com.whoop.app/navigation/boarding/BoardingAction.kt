package com.whoop.app.navigation.boarding

import androidx.navigation.NavHostController
import com.whoop.app.navigation.utils.DestinationsConstant.BOARDING_SCREEN
import com.whoop.app.navigation.utils.DestinationsConstant.LOGIN_SCREEN
import com.whoop.app.navigation.utils.DestinationsConstant.MAIN_SCREEN
import com.whoop.app.navigation.utils.DestinationsConstant.SPLASHSCREEN

class BoardingAction(
    navController: NavHostController
) {
    val openMain = {
        navController.navigate(MAIN_SCREEN) {
            popUpTo(SPLASHSCREEN) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }

    val openMainFromBoarding = {
        navController.navigate(MAIN_SCREEN) {
            popUpTo(BOARDING_SCREEN) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }

    val openBoarding = {
        navController.navigate(BOARDING_SCREEN) {
            popUpTo(SPLASHSCREEN) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }

    val openLoginFromSplash = {
        navController.navigate(LOGIN_SCREEN) {
            popUpTo(SPLASHSCREEN) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }

    val openLoginFromBoarding = {
        navController.navigate(LOGIN_SCREEN) {
            popUpTo(BOARDING_SCREEN) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }

    val openMainFromLogin = {
        navController.navigate(MAIN_SCREEN) {
            popUpTo(LOGIN_SCREEN) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }
}
