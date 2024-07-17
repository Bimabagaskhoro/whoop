package com.whoop.app.feature.main.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.whoop.app.feature.main.presentation.component.BottomBar
import com.whoop.app.navigation.main.MainNavGraph
import com.whoop.app.navigation.main.MainSections
import org.koin.compose.koinInject

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel = koinInject()
) {
    val navController = rememberNavController()
    val tabs = remember { MainSections.entries.toTypedArray() }

    Scaffold(
        bottomBar = {
            BottomBar(
                tabs = tabs,
                navController = navController
            )
        },
    ) { innerPadding ->
        MainNavGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}
