package com.whoop.app.feature.splashscreen.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.compose.koinInject
import kotlin.time.Duration.Companion.seconds

@Composable
fun Splashscreen(
    openBoarding: () -> Unit,
    openMain: () -> Unit,
    viewModel: SplashViewModel = koinInject()
) {
    val boardingStatus by viewModel.checkBoardingStatus.collectAsState()

    LaunchedEffect(Unit) {
        delay(1.seconds)
        if (boardingStatus) {
            launch {
                delay(3000)
                openMain()
            }
        } else {
            launch {
                delay(3000)
                openBoarding()
            }
        }
    }

    Scaffold {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = Icons.Sharp.Done,
                contentDescription = null,
                modifier = Modifier
                    .width(217.dp)
                    .height(77.dp)
                    .align(Alignment.Center)
            )
        }
    }
}
