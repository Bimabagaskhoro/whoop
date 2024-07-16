package com.whoop.app.design.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseScreen(
    title: String,
    navigateBack: () -> Unit,
    leftIcon: @Composable () -> Unit,
    iconBack: Boolean = true,
    iconLeft: Boolean = true,
    content: @Composable (PaddingValues) -> Unit
) {
    val scrollBehavior = pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    TitleMediumText(
                        text = title
                    )
                },
                navigationIcon = {
                    if (iconBack) {
                        IconButton(onClick = navigateBack) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                tint = colorScheme.primary,
                                contentDescription = null
                            )
                        }
                    }
                },
                actions = {
                    if (iconLeft) {
                        leftIcon()
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White
                ),
                scrollBehavior = scrollBehavior
            )
        }
    ) { content(it) }
}
