package com.whoop.app.design.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import androidx.compose.material3.Typography
import whoop.composeapp.generated.resources.Montserrat_Black
import whoop.composeapp.generated.resources.Montserrat_Bold
import whoop.composeapp.generated.resources.Montserrat_ExtraBold
import whoop.composeapp.generated.resources.Montserrat_ExtraLight
import whoop.composeapp.generated.resources.Montserrat_Light
import whoop.composeapp.generated.resources.Montserrat_Medium
import whoop.composeapp.generated.resources.Montserrat_Regular
import whoop.composeapp.generated.resources.Montserrat_SemiBold
import whoop.composeapp.generated.resources.Montserrat_Thin
import whoop.composeapp.generated.resources.Res

@Composable
fun MontserratFontFamily() = FontFamily(
    Font(Res.font.Montserrat_Black, weight = FontWeight.Black),
    Font(Res.font.Montserrat_Bold, weight = FontWeight.Bold),
    Font(Res.font.Montserrat_ExtraBold, weight = FontWeight.ExtraBold),
    Font(Res.font.Montserrat_ExtraLight, weight = FontWeight.ExtraLight),
    Font(Res.font.Montserrat_Light, weight = FontWeight.Light),
    Font(Res.font.Montserrat_Medium, weight = FontWeight.Medium),
    Font(Res.font.Montserrat_Regular, weight = FontWeight.Normal),
    Font(Res.font.Montserrat_SemiBold, weight = FontWeight.SemiBold),
    Font(Res.font.Montserrat_Thin, weight = FontWeight.Thin),
)

@Composable
fun AppTypography() = Typography().run {
    val fontFamily = MontserratFontFamily()
    copy(
        displayLarge = displayLarge.copy(fontFamily = fontFamily),
        displayMedium = displayMedium.copy(fontFamily = fontFamily),
        displaySmall = displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = titleLarge.copy(fontFamily = fontFamily),
        titleMedium = titleMedium.copy(fontFamily = fontFamily),
        titleSmall = titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = bodyLarge.copy(fontFamily =  fontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = bodySmall.copy(fontFamily = fontFamily),
        labelLarge = labelLarge.copy(fontFamily = fontFamily),
        labelMedium = labelMedium.copy(fontFamily = fontFamily),
        labelSmall = labelSmall.copy(fontFamily = fontFamily)
    )
}
