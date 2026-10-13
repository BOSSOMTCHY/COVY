package com.example.covy.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.ui.theme.VertFonce
import com.example.covy.ui.theme.VertJaune

/**
 * Composant représentant le logo Covy avec l'icône des 3 silhouettes et le mot Covy.
 */
@Composable
fun CovyLogo(
    modifier: Modifier = Modifier,
    iconSize: Dp = 120.dp,
    showText: Boolean = true,
    textSize: Float = 42f
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Icône du Logo avec Canvas
        Canvas(modifier = Modifier.size(iconSize)) {
            val width = size.width
            val height = size.height

            // Vert foncé pour le bonhomme du milieu et droit
            val darkGreen = Color(0xFF004D34)
            // Jaune/Orangé pour le bonhomme de droite
            val yellowGold = Color(0xFFF4B41A)
            // Vert clair/moyen pour le bonhomme de gauche
            val lightGreen = Color(0xFF1E824C)

            // Têtes (Cercles)
            drawCircle(color = lightGreen, center = Offset(width * 0.32f, height * 0.28f), radius = width * 0.12f)
            drawCircle(color = darkGreen, center = Offset(width * 0.50f, height * 0.22f), radius = width * 0.14f)
            drawCircle(color = yellowGold, center = Offset(width * 0.68f, height * 0.28f), radius = width * 0.12f)

            // Corps / Épaules (Arc)
            val pathLeft = Path().apply {
                moveTo(width * 0.12f, height * 0.70f)
                cubicTo(width * 0.12f, height * 0.45f, width * 0.52f, height * 0.45f, width * 0.52f, height * 0.70f)
                close()
            }
            drawPath(path = pathLeft, color = lightGreen)

            val pathCenter = Path().apply {
                moveTo(width * 0.28f, height * 0.72f)
                cubicTo(width * 0.28f, height * 0.40f, width * 0.72f, height * 0.40f, width * 0.72f, height * 0.72f)
                close()
            }
            drawPath(path = pathCenter, color = darkGreen)

            val pathRight = Path().apply {
                moveTo(width * 0.48f, height * 0.70f)
                cubicTo(width * 0.48f, height * 0.45f, width * 0.88f, height * 0.45f, width * 0.88f, height * 0.70f)
                close()
            }
            drawPath(path = pathRight, color = yellowGold)

            // Route blanche au centre (s'évase vers le bas)
            val roadPath = Path().apply {
                moveTo(width * 0.48f, height * 0.42f)
                cubicTo(width * 0.40f, height * 0.60f, width * 0.35f, height * 0.75f, width * 0.30f, height * 0.95f)
                lineTo(width * 0.70f, height * 0.95f)
                cubicTo(width * 0.65f, height * 0.75f, width * 0.60f, height * 0.60f, width * 0.52f, height * 0.42f)
                close()
            }
            drawPath(path = roadPath, color = Color.White)
        }

        if (showText) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Covy",
                color = VertFonce,
                fontSize = textSize.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = (-0.5).sp
            )
        }
    }
}

/**
 * Petit Logo Covy pour la barre d'en-tête (Header)
 */
@Composable
fun CovyHeaderLogo(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        CovyLogo(
            iconSize = 28.dp,
            showText = false
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = "Covy",
            color = VertFonce,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
