package com.medlabel.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF006689),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFC3E8FF),
    onPrimaryContainer = Color(0xFF001E2C),
    secondary = Color(0xFF4E616D),
    background = Color(0xFFFBFCFE),
    surface = Color(0xFFFBFCFE),
)

@Composable
fun MedLabelTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content
    )
}
