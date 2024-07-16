package com.whoop.app.feature.login.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mmk.kmpauth.google.GoogleButtonUiContainer
import com.mmk.kmpauth.uihelper.google.GoogleSignInButton
import com.whoop.app.core.base.utils.onSuccess
import com.whoop.app.design.component.BaseScreen
import com.whoop.app.design.component.TitleMediumText
import com.whoop.app.design.theme.whoop_text_black
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject
import whoop.composeapp.generated.resources.Res
import whoop.composeapp.generated.resources.anonymous_title
import whoop.composeapp.generated.resources.google_title
import whoop.composeapp.generated.resources.title_login

@Composable
fun LoginScreen(
    openMainFromLogin: () -> Unit,
    viewModel: LoginViewModel = koinInject()
) {
    val initGoogleAuthProvider by viewModel.initGoogleAuthProvider.collectAsState()
    val uiState by viewModel.uiState.collectAsState()

    uiState
        .onSuccess {
            openMainFromLogin()
        }

    BaseScreen(
        title = "",
        navigateBack = {},
        rightIcon = {},
        leftIcon = {},
        centerIcon = {}
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .background(color = MaterialTheme.colorScheme.surface),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(32.dp))
            Text(
                modifier = Modifier.fillMaxWidth().padding(top = 80.dp),
                text = stringResource(Res.string.title_login),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = whoop_text_black,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
            )
            Spacer(Modifier.height(32.dp))
            if (initGoogleAuthProvider) {
                GoogleButtonUiContainer(
                    onGoogleSignInResult = { token ->
                        viewModel.saveToken(token?.idToken)
                        viewModel.googleToken()
                        viewModel.uiState()
                    }
                ) {
                    GoogleSignInButton(
                        text = stringResource(Res.string.google_title)
                    ) {
                        onClick()
                    }
                }
            }
            Spacer(Modifier.height(12.dp))
            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .clickable {
                        viewModel.saveToken()
                        viewModel.anonymousToken()
                        viewModel.uiState()
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TitleMediumText(
                    text = stringResource(Res.string.anonymous_title).lowercase(),
                    color = whoop_text_black,
                )
            }
        }
    }
}
