package com.example.covy.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.ui.theme.TextBlack
import com.example.covy.ui.theme.TextGray
import com.example.covy.ui.theme.VertCovy
import com.example.covy.ui.theme.VertFonce

/**
 * COMPOSANT : Carte d'Information (InfoCard)
 * Carte arrondie à fond vert vert-clair utilisée pour afficher des conseils ou consignes.
 *
 * Exexmples d'utilisation :
 * - "Un dossier pour chaque profil" sur l'écran Bienvenue
 * - "Votre compte, votre trajet" sur l'écran Connexion
 * - "Un code à 6 chiffres" sur l'écran Récupération
 * - "Consultez vos SMS" sur l'écran Vérification
 *
 * @param modifier Modificateurs Compose
 * @param icon Icône vectorielle affichée dans un petit carré blanc
 * @param title Titre en gras de la carte
 * @param description Description détaillée ou consigne
 * @param backgroundColor Couleur de fond de la carte (VertCovy par défaut)
 * @param iconTintColor Couleur de l'icône (VertFonce par défaut)
 */
@Composable
fun CovyInfoCard(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    title: String,
    description: String,
    backgroundColor: Color = VertCovy,
    iconTintColor: Color = VertFonce
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        Column {
            // Ligne du haut : Petit carré d'icône blanc + Titre
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Petit carré blanc contenant l'icône
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White.copy(alpha = 0.8f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = iconTintColor,
                        modifier = Modifier.size(20.dp)
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                // Titre de la carte
                Text(
                    text = title,
                    color = TextBlack,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Texte de description
            Text(
                text = description,
                color = TextGray,
                fontSize = 13.sp,
                lineHeight = 18.sp
            )
        }
    }
}
