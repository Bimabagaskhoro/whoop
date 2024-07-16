package com.whoop.app.navigation.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.whoop.app.feature.home.presentation.HomeScreen
import com.whoop.app.feature.find.presentation.detail.FindDetailScreen
import com.whoop.app.feature.find.presentation.main.FindScreen
import com.whoop.app.feature.chat.presentation.ChatScreen
import com.whoop.app.navigation.utils.ArgsConstant.ID_FIND_DETAIL
import com.whoop.app.navigation.utils.DestinationsConstant.MAIN_SCREEN
import com.whoop.app.navigation.utils.DestinationsConstant.FIND_DETAIL_SCREEN

@ExperimentalAnimationApi
@Composable
fun MainNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = MAIN_SCREEN,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier.fillMaxSize()
    ) {
        navigation(
            route = MAIN_SCREEN,
            startDestination = MainSections.HOME.route
        ) {
            composable(MainSections.HOME.route) {
                HomeScreen()
            }
            composable(MainSections.FIND.route) {
                FindScreen(
                    navController = navController
                )
            }
            composable(MainSections.CHAT.route) {
                ChatScreen()
            }
        }

        composable(
            route = "$FIND_DETAIL_SCREEN/{$ID_FIND_DETAIL}",
            arguments = listOf(
                navArgument(ID_FIND_DETAIL) { type = NavType.IntType })
        ) { from: NavBackStackEntry ->
            val arguments = requireNotNull(from.arguments)
            val id = arguments.getInt(ID_FIND_DETAIL)

            FindDetailScreen(
                navController = navController
            )
        }
    }
}