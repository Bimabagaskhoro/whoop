package com.whoop.app.feature.splashscreen.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import whoop.composeapp.generated.resources.Res
import whoop.composeapp.generated.resources.ic_logo
import kotlin.time.Duration.Companion.seconds

@Composable
fun Splashscreen(
    openBoarding: () -> Unit,
    openMain: () -> Unit,
    openLogin: () -> Unit,
    viewModel: SplashViewModel = koinInject()
) {
    val boardingStatus by viewModel.checkBoardingStatus.collectAsState()
    val checkGoogleSignIn by viewModel.checkGoogleSignIn.collectAsState()

    LaunchedEffect(Unit) {
        delay(1.seconds)
        when {
            boardingStatus && checkGoogleSignIn -> {
                delay(3000)
                openMain()
            }

            boardingStatus -> {
                delay(3000)
                openLogin()
            }

            else -> {
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
                painter = painterResource(Res.drawable.ic_logo),
                tint = Color.Unspecified,
                contentDescription = null,
                modifier = Modifier
                    .width(217.dp)
                    .height(77.dp)
                    .align(Alignment.Center)
            )
        }
    }
}
