package com.whoop.app.design.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import com.whoop.app.design.theme.whoop_text_black

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseScreen(
    title: String,
    navigateBack: () -> Unit,
    rightIcon: @Composable () -> Unit,
    centerIcon: @Composable () -> Unit,
    leftIcon: @Composable () -> Unit,
    iconBack: Boolean = false,
    iconLeft: Boolean = false,
    content: @Composable (PaddingValues) -> Unit
) {
    val scrollBehavior = pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    if (title.isNotEmpty()) {
                        TitleMediumText(
                            text = title,
                            color = whoop_text_black
                        )
                    } else {
                        centerIcon()
                    }
                },
                navigationIcon = {
                    if (iconBack) {
                        IconButton(onClick = navigateBack) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                tint = MaterialTheme.colorScheme.surface,
                                contentDescription = null
                            )
                        }
                    } else {
                        rightIcon()
                    }
                },
                actions = {
                    if (iconLeft) {
                        leftIcon()
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                scrollBehavior = scrollBehavior
            )
        },
    ) { content(it) }
}
