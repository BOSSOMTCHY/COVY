package com.example.covy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.School
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.ui.components.*
import com.example.covy.ui.theme.*

/**
 * ÉCRAN 9 : Votre Vie de Campus (Étape 08 / 30) - Parcours Étudiant
 *
 * Formulaire de validation de la scolarité universitaire :
 * Saisie du matricule, sélection de l'université, niveau d'études, et dépôt de la carte étudiante.
 *
 * @param onNavigateBack Retour à l'écran précédent
 * @param onSubmitDossier Soumission finale du dossier étudiant
 */
@Composable
fun CampusLifeScreen(
    onNavigateBack: () -> Unit,
    onSubmitDossier: () -> Unit
) {
    // États locaux stockant les saisies du dossier étudiant
    var matricule by remember { mutableStateOf("ETU-2026-08421") }
    var universityName by remember { mutableStateOf("Université de Bingerville") }
    var studyLevel by remember { mutableStateOf("Licence 2") }
    var fileName by remember { mutableStateOf("carte-etudiants.pdf") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // En-tête avec étape "08 / 30"
        CovyHeader(
            stepText = "08 / 30",
            onBackClick = onNavigateBack
        )

        // Corps du formulaire avec défilement
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 8.dp)
        ) {
            // Sur-titre / Catégorie
            Text(
                text = "INSCRIPTION • ÉTUDIANT",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = TextGray,
                letterSpacing = 0.5.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Titre principal
            Text(
                text = "Votre vie de campus",
                fontSize = 26.sp,
                fontWeight = FontWeight.ExtraBold,
                color = TextBlack
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Sous-titre
            Text(
                text = "Ces informations servent à vérifier votre scolarité.",
                fontSize = 13.sp,
                color = TextGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Barre de progression : "Scolarité - Étape 3 sur 3"
            StepProgressBar(
                title = "Scolarité - Étape 3 sur 3",
                currentStep = 3,
                totalSteps = 3
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Champ Matricule *
            CovyTextField(
                value = matricule,
                onValueChange = { matricule = it },
                label = "Matricule *"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Champ Nom de l'université / école *
            CovyTextField(
                value = universityName,
                onValueChange = { universityName = it },
                label = "Nom de l'université / école *",
                trailingIcon = Icons.Outlined.School
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Selecteur / Champ Niveau d'études
            CovyTextField(
                value = studyLevel,
                onValueChange = { studyLevel = it },
                label = "Niveau d'études",
                trailingIcon = Icons.Outlined.ArrowDropDown
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Libellé de la pièce jointe
            Text(
                text = "Carte étudiante / scolaire *",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextBlack,
                modifier = Modifier.padding(bottom = 6.dp)
            )

            // Carte du document téléversé (carte étudiante)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(VertCovy.copy(alpha = 0.5f))
                    .border(1.dp, VertBadge, RoundedCornerShape(14.dp))
                    .clickable { /* Action remplacer document */ }
                    .padding(14.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Description,
                            contentDescription = null,
                            tint = VertFonce,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Text(
                            text = fileName,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextBlack
                        )
                        Text(
                            text = "Document ajouté • Remplacer",
                            fontSize = 11.sp,
                            color = TextGray
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Carte de confidentialité "Vos documents restent privés"
            CovyInfoCard(
                icon = Icons.Outlined.Lock,
                title = "Vos documents restent privés",
                description = "Utilisé pour l'examen du dossier, non affiché aux autres passagers."
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Remarque champs obligatoires
            Text(
                text = "* Matricule, établissement et carte obligatoires.",
                fontSize = 11.sp,
                color = TextMuted
            )

            Spacer(modifier = Modifier.height(24.dp))
        }

        // Zone d'action au bas de la page
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp)
        ) {
            CovyButton(
                text = "Envoyer mon dossier étudiant",
                onClick = onSubmitDossier
            )
        }
    }
}
