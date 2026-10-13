package com.example.covy.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.ui.theme.TextGray

/**
 * COMPOSANT : En-tête standard (Header)
 * Présent en haut des écrans de parcours.
 *
 * Contient :
 * 1. Une flèche de retour arrière (si 'onBackClick' est fourni)
 * 2. Le logo Covy miniature
 * 3. Le numéro d'étape à droite (ex: "01 / 30", "02 / 30")
 *
 * @param modifier Modificateurs Compose
 * @param stepText Texte d'étape affiché à droite (ex: "01 / 30"). Si null, rien n'est affiché.
 * @param onBackClick Action appelée au clic sur la flèche de retour. Si null, pas de flèche.
 */
@Composable
fun CovyHeader(
    modifier: Modifier = Modifier,
    stepText: String? = null,
    onBackClick: (() -> Unit)? = null
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Partie gauche : Flèche de retour + Logo
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Affichage de la flèche uniquement si un clic de retour est défini
            if (onBackClick != null) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Bouton Retour",
                        tint = Color(0xFF111827)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
            }

            // Logo Covy miniature
            CovyHeaderLogo()
        }

        // Partie droite : Badge indiquant l'étape (ex: 01 / 30)
        if (stepText != null) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFF3F4F6))
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Text(
                    text = stepText,
                    color = TextGray,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
