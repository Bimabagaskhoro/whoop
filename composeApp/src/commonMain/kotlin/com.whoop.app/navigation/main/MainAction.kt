package com.whoop.app.navigation.main

import androidx.navigation.NavHostController
import com.whoop.app.navigation.utils.DestinationsConstant.FIND_DETAIL_SCREEN

class MainAction(
    navController: NavHostController
) {
    val openDetail = { id: Long ->
        navController.navigate("$FIND_DETAIL_SCREEN/$id") {
            launchSingleTop = true
        }
    }
}

