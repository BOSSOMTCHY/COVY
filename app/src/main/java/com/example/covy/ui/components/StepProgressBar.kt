package com.example.covy.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.ui.theme.BordureCovy
import com.example.covy.ui.theme.TextBlack
import com.example.covy.ui.theme.VertFonce

/**
 * COMPOSANT : Indicateur de Sous-Étape avec Barre de Progression
 * Affiche le nom de la sous-étape (ex: "Profil passager - Étape 1 sur 4")
 * et une fine ligne horizontale représentant la progression.
 *
 * @param title Titre de l'étape (ex: "Profil passager - Étape 1 sur 4")
 * @param currentStep Numéro de l'étape actuelle (ex: 1)
 * @param totalSteps Nombre total d'étapes (ex: 4)
 */
@Composable
fun StepProgressBar(
    title: String,
    currentStep: Int,
    totalSteps: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        // Intitulé de la sous-étape
        Text(
            text = title,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = TextBlack
        )

        Spacer(modifier = Modifier.height(6.dp))

        // Barre de progression horizontale
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .clip(RoundedCornerShape(2.dp))
                .background(BordureCovy)
        ) {
            val progressFraction = (currentStep.toFloat() / totalSteps.toFloat()).coerceIn(0f, 1f)
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(fraction = progressFraction)
                    .clip(RoundedCornerShape(2.dp))
                    .background(VertFonce)
            )
        }
    }
}
