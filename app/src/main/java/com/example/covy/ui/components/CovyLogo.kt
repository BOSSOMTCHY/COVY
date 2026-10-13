package com.example.covy.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.ui.theme.VertFonce

/**
 * COMPOSANT : Logo Covy complet
 * Dessine les 3 silhouettes représentant le covoiturage (3 personnes) ainsi que le chemin/route,
 * suivi du texte "Covy" en gras.
 *
 * @param modifier Modificateurs Compose de taille/marge
 * @param iconSize Taille du dessin du logo
 * @param showText Si true, affiche le texte "Covy" en dessous du logo
 * @param textSize Taille de la police du texte "Covy"
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
        // Dessin vectoriel personnalisé du logo grâce à Canvas
        Canvas(modifier = Modifier.size(iconSize)) {
            val width = size.width
            val height = size.height

            // Définition des 3 couleurs du logo (Vert foncé, Jaune/Or, Vert moyen)
            val darkGreen = Color(0xFF004D34)
            val yellowGold = Color(0xFFF4B41A)
            val lightGreen = Color(0xFF1E824C)

            // 1. Têtes des 3 personnes (3 cercles)
            drawCircle(color = lightGreen, center = Offset(width * 0.32f, height * 0.28f), radius = width * 0.12f)
            drawCircle(color = darkGreen, center = Offset(width * 0.50f, height * 0.22f), radius = width * 0.14f)
            drawCircle(color = yellowGold, center = Offset(width * 0.68f, height * 0.28f), radius = width * 0.12f)

            // 2. Épaules / Buste de la personne de gauche (Vert clair)
            val pathLeft = Path().apply {
                moveTo(width * 0.12f, height * 0.70f)
                cubicTo(width * 0.12f, height * 0.45f, width * 0.52f, height * 0.45f, width * 0.52f, height * 0.70f)
                close()
            }
            drawPath(path = pathLeft, color = lightGreen)

            // 3. Épaules / Buste de la personne du milieu (Vert foncé)
            val pathCenter = Path().apply {
                moveTo(width * 0.28f, height * 0.72f)
                cubicTo(width * 0.28f, height * 0.40f, width * 0.72f, height * 0.40f, width * 0.72f, height * 0.72f)
                close()
            }
            drawPath(path = pathCenter, color = darkGreen)

            // 4. Épaules / Buste de la personne de droite (Jaune)
            val pathRight = Path().apply {
                moveTo(width * 0.48f, height * 0.70f)
                cubicTo(width * 0.48f, height * 0.45f, width * 0.88f, height * 0.45f, width * 0.88f, height * 0.70f)
                close()
            }
            drawPath(path = pathRight, color = yellowGold)

            // 5. La route blanche au centre qui s'élargit vers le bas
            val roadPath = Path().apply {
                moveTo(width * 0.48f, height * 0.42f)
                cubicTo(width * 0.40f, height * 0.60f, width * 0.35f, height * 0.75f, width * 0.30f, height * 0.95f)
                lineTo(width * 0.70f, height * 0.95f)
                cubicTo(width * 0.65f, height * 0.75f, width * 0.60f, height * 0.60f, width * 0.52f, height * 0.42f)
                close()
            }
            drawPath(path = roadPath, color = Color.White)
        }

        // Affichage optionnel de l'écriture "Covy"
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
 * COMPOSANT : Version miniature du Logo pour la barre d'en-tête (Header)
 */
@Composable
fun CovyHeaderLogo(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        // Petit icône seul sans texte en dessous
        CovyLogo(
            iconSize = 28.dp,
            showText = false
        )
        Spacer(modifier = Modifier.width(6.dp))
        // Nom de l'application aligné à côté du logo
        Text(
            text = "Covy",
            color = VertFonce,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
