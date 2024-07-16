package com.whoop.app.design.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun BodyLargeText(
    text: String,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyLarge.copy(
            letterSpacing = (-0.05).sp,
            color = color,
        ),
        maxLines = 1
    )
}

@Composable
fun BodyMediumText(
    text: String,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium.copy(
            letterSpacing = (-0.05).sp,
            color = color,
            fontWeight = FontWeight.SemiBold,
        ),
        maxLines = 1
    )
}

@Composable
fun BodySmallText(
    text: String,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall.copy(
            letterSpacing = (-0.05).sp,
            color = color,
            fontSize = 8.sp,
        ),
        maxLines = 1
    )
}

@Composable
fun TitleMediumText(
    text: String,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium.copy(
            letterSpacing = (-0.05).sp,
            color = color,
        ),
        maxLines = 1
    )
}