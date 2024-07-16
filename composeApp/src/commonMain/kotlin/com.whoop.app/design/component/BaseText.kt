package com.whoop.app.design.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun BodyLargeText(
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    text: String,
    size: Int = 16,
    maxLines: Int = 1,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyLarge.copy(
            letterSpacing = (-0.05).sp,
            color = color,
            fontSize = size.sp,
            textAlign = TextAlign.Center
        ),
        maxLines = 1
    )
}

@Composable
fun BodyMediumText(
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    text: String,
    size: Int = 14,
    maxLines: Int = 1,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium.copy(
            letterSpacing = (-0.05).sp,
            color = color,
            fontSize = size.sp,
            fontWeight = FontWeight.SemiBold,
        ),
        textAlign = textAlign,
        maxLines = maxLines
    )
}

@Composable
fun BodySmallText(
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
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
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
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

@Composable
fun TitleSmallText(
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    size: Int = 14,
    text: String,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleSmall.copy(
            letterSpacing = (-0.05).sp,
            color = color,
            fontSize = size.sp,
        ),
        maxLines = 1
    )
}
