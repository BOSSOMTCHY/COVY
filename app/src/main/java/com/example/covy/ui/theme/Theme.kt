package com.example.covy.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Palette de couleurs Material 3 configurée pour Covy
private val PaletteCovy = lightColorScheme(
    primary = VertFonce,
    secondary = VertCovy,
    background = FondCovy,
    surface = Color.White
)

// Thème principal à appliquer autour de votre application
@Composable
fun CovyTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = PaletteCovy,
        content = content
    )
}
