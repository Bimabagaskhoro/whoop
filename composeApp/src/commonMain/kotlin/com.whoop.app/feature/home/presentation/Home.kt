package com.whoop.app.feature.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.whoop.app.design.component.BaseScreen
import org.jetbrains.compose.resources.painterResource
import whoop.composeapp.generated.resources.Res
import whoop.composeapp.generated.resources.ic_logo

@Composable
fun HomeScreen() {
    BaseScreen(
        title = "",
        navigateBack = {},
        rightIcon = {},
        leftIcon = {},
        centerIcon = {
            Icon(
                painter = painterResource(Res.drawable.ic_logo),
                tint = Color.Unspecified,
                contentDescription = null,
                modifier = Modifier.height(32.dp).width(80.dp)
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .background(color = MaterialTheme.colorScheme.surface),
        ) {

        }
    }
}
