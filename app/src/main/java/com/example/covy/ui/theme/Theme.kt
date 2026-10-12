package com.example.covy.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Palette Material utilisée par toute l'application
private val PaletteCovy = lightColorScheme(
    primary = VertFonce,
    secondary = VertCovy,
    background = FondCovy,
    surface = Color.White
)

// Thème à placer autour de tous les écrans (voir MainActivity)
@Composable
fun ThemeCovy(contenu: @Composable () -> Unit) {
    MaterialTheme(colorScheme = PaletteCovy, content = contenu)
}