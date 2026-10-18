package com.example.covy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.outlined.School
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.ui.components.CovyHeader
import com.example.covy.ui.theme.*

/**
 * ÉCRAN 6 : Votre Parcours Étudiant (Étape 05 / 30)
 *
 * Première étape du parcours d'inscription étudiant/élève.
 * Présente le profil "Étudiant / Élève" et permet de lancer l'inscription comme passager.
 *
 * @param onNavigateBack Retour à l'écran précédent
 * @param onNavigateToPassengerRole Redirection vers le choix du profil (06/30)
 * @param onNavigateToLogin Redirection vers la page de connexion
 */
@Composable
fun StudentPathwayScreen(
    onNavigateBack: () -> Unit,
    onNavigateToPassengerRole: () -> Unit,
    onNavigateToLogin: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // En-tête avec flèche retour et étape "05 / 30"
        CovyHeader(
            stepText = "05 / 30",
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
                text = "INSCRIPTION • PROFIL",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = TextGray,
                letterSpacing = 0.5.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Titre principal
            Text(
                text = "Votre parcours étudiant",
                fontSize = 26.sp,
                fontWeight = FontWeight.ExtraBold,
                color = TextBlack
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Sous-titre
            Text(
                text = "Étudiant ou élève, créez votre compte pour rejoindre votre école ou votre université.",
                fontSize = 13.sp,
                color = TextGray,
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Carte d'inscription Passager (Étudiant / Élève)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White)
                    .border(1.dp, BordureCovy, RoundedCornerShape(20.dp))
                    .clickable { onNavigateToPassengerRole() }
                    .padding(20.dp)
            ) {
                Column {
                    // Icône Chapeau de diplômé dans un cercle vert clair
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(VertCovy),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.School,
                            contentDescription = null,
                            tint = VertFonce,
                            modifier = Modifier.size(26.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Titre de la carte
                    Text(
                        text = "Étudiant / Élève",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextBlack
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    // Description de l'option
                    Text(
                        text = "Je rejoins mon école ou mon université en covoiturage.",
                        fontSize = 13.sp,
                        color = TextGray,
                        lineHeight = 18.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Lien d'action : "M'inscrire comme passager >"
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "M'inscrire comme passager",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = VertFonce
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null,
                            tint = VertFonce,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }

        // Zone d'action au bas de l'écran : "Déjà inscrit ? Se connecter"
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Déjà inscrit ? Se connecter",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = VertFonce,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clickable { onNavigateToLogin() }
                    .padding(8.dp)
            )
        }
    }
}
