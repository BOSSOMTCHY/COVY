package com.example.covy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.ui.components.*
import com.example.covy.ui.theme.*

/**
 * ÉCRAN 7 : Votre Scolarité (Étape 06 / 30)
 *
 * Sélection du type de profil passager : "Étudiant" (Université) ou "Élève" (Collège/Lycée).
 *
 * @param onNavigateBack Retour à l'écran précédent
 * @param onContinue Action suite au choix du profil -> Redirige vers 07/30 (Formulaire d'identité)
 */
@Composable
fun PassengerRoleScreen(
    onNavigateBack: () -> Unit,
    onContinue: (Boolean) -> Unit // true = Étudiant, false = Élève
) {
    // État gérant l'option sélectionnée (true = Étudiant par défaut)
    var isStudentSelected by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // En-tête avec étape "06 / 30"
        CovyHeader(
            stepText = "06 / 30",
            onBackClick = onNavigateBack
        )

        // Corps de la page avec défilement
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 8.dp)
        ) {
            // Sur-titre / Catégorie
            Text(
                text = "INSCRIPTION • PASSAGER",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = TextGray,
                letterSpacing = 0.5.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Titre principal
            Text(
                text = "Votre scolarité",
                fontSize = 26.sp,
                fontWeight = FontWeight.ExtraBold,
                color = TextBlack
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Sous-titre
            Text(
                text = "Un espace passager commun, un dossier adapté à votre situation.",
                fontSize = 13.sp,
                color = TextGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Barre de sous-étape : "Profil passager - Étape 1 sur 4"
            StepProgressBar(
                title = "Profil passager - Étape 1 sur 4",
                currentStep = 1,
                totalSteps = 4
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Option 1 : Étudiant (Université / Enseignement supérieur)
            RadioSelectionCard(
                selected = isStudentSelected,
                onClick = { isStudentSelected = true },
                title = "Étudiant",
                subtitle = "Université ou enseignement supérieur",
                description = "Matricule et carte étudiante nécessaires."
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Option 2 : Élève (Collège ou Lycée)
            RadioSelectionCard(
                selected = !isStudentSelected,
                onClick = { isStudentSelected = false },
                title = "Élève",
                subtitle = "Collège ou lycée",
                description = "Carte scolaire, parent ou tuteur et contact d'urgence nécessaires."
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Note informative
            Text(
                text = "Votre choix déterminera les prochaines étapes d'inscription.",
                fontSize = 12.sp,
                color = TextGray
            )

            Spacer(modifier = Modifier.height(24.dp))
        }

        // Zone d'action au bas de l'écran : Bouton "Continuer"
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp)
        ) {
            CovyButton(
                text = "Continuer",
                onClick = { onContinue(isStudentSelected) }
            )
        }
    }
}
