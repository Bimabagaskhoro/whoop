package com.whoop.app.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.whoop.app.shared.SystemAppearance

private val LightColorScheme = lightColorScheme(
    primary = whoop_light_primary,
    onPrimary = whoop_light_onPrimary,
    primaryContainer = whoop_light_primaryContainer,
    onPrimaryContainer = whoop_light_onPrimaryContainer,
    secondary = whoop_light_secondary,
    onSecondary = whoop_light_onSecondary,
    secondaryContainer = whoop_light_secondaryContainer,
    onSecondaryContainer = whoop_light_onSecondaryContainer,
    tertiary = whoop_light_tertiary,
    onTertiary = whoop_light_onTertiary,
    background = whoop_light_background,
    onBackground = whoop_light_onBackground,
    surface = whoop_light_surface,
    onSurface = whoop_light_onSurface,
    error = whoop_light_error,
    onError = whoop_light_onError,
)

private val DarkColorScheme = darkColorScheme(
    primary = whoop_dark_primary,
    onPrimary = whoop_dark_onPrimary,
    primaryContainer = whoop_dark_primaryContainer,
    onPrimaryContainer = whoop_dark_onPrimaryContainer,
    secondary = whoop_dark_secondary,
    onSecondary = whoop_dark_onSecondary,
    secondaryContainer = whoop_dark_secondaryContainer,
    onSecondaryContainer = whoop_dark_onSecondaryContainer,
    tertiary = whoop_dark_tertiary,
    onTertiary = whoop_dark_onTertiary,
    background = whoop_dark_background,
    onBackground = whoop_dark_onBackground,
    surface = whoop_dark_surface,
    onSurface = whoop_dark_onSurface,
    error = whoop_dark_error,
    onError = whoop_dark_onError,
)


internal val LocalThemeIsDark = compositionLocalOf { mutableStateOf(true) }

@Composable
internal fun AppTheme(
    content: @Composable() () -> Unit
) {
    val systemIsDark = isSystemInDarkTheme()
    val isDarkState = remember { mutableStateOf(systemIsDark) }
    CompositionLocalProvider(
        value = LocalThemeIsDark provides isDarkState
    ) {
        val isDark by isDarkState
        SystemAppearance(!isDark)
        MaterialTheme(
            colorScheme = if (isDark) DarkColorScheme else LightColorScheme,
            typography = AppTypography(),
            content = { Surface(content = content) }
        )
    }
}
