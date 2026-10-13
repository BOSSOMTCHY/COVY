package com.example.covy.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Shield
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.ui.components.CovyButton
import com.example.covy.ui.components.CovyHeader
import com.example.covy.ui.components.CovyInfoCard
import com.example.covy.ui.theme.*

/**
 * ÉCRAN 2 : Bienvenue Covy (01 / 30)
 *
 * Première étape du parcours d'intégration (Onboarding).
 * Présente le concept du covoiturage étudiant à Abidjan avec un visuel,
 * une carte d'information sur les dossiers et deux boutons principaux.
 *
 * @param onNavigateToLogin Redirection vers la page de connexion (02/30)
 * @param onNavigateToRegister Redirection vers la création de compte
 */
@Composable
fun WelcomeScreen(
    onNavigateToLogin: () -> Unit,
    onNavigateToRegister: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // En-tête avec indicateur d'étape "01 / 30"
        CovyHeader(
            stepText = "01 / 30"
        )

        // Corps de la page défilable
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 8.dp)
        ) {
            // Sur-titre / Catégorie
            Text(
                text = "BIENVENUE • ABIDJAN",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = TextGray,
                letterSpacing = 0.5.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Titre principal
            Text(
                text = "Le campus, ensemble.",
                fontSize = 26.sp,
                fontWeight = FontWeight.ExtraBold,
                color = TextBlack
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Sous-titre
            Text(
                text = "Le covoiturage scolaire et universitaire à Abidjan.",
                fontSize = 13.sp,
                color = TextGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Illustration visuelle de la communauté et de la voiture
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(VertCovy),
                contentAlignment = Alignment.Center
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    val width = size.width
                    val height = size.height

                    // Fond paysage vert d'eau
                    drawRect(color = Color(0xFFE8F5E9))

                    // Bandes de route
                    drawRect(
                        color = Color(0xFFD0E8D6),
                        topLeft = Offset(0f, height * 0.70f),
                        size = Size(width, height * 0.30f)
                    )

                    // Silhouette de la voiture verte
                    drawRoundRect(
                        color = VertFonce,
                        topLeft = Offset(width * 0.55f, height * 0.55f),
                        size = Size(width * 0.38f, height * 0.25f),
                        cornerRadius = CornerRadius(16f, 16f)
                    )

                    // Silhouettes des 3 étudiants
                    drawCircle(color = Color(0xFF333333), center = Offset(width * 0.20f, height * 0.45f), radius = 22f)
                    drawCircle(color = Color(0xFF004D34), center = Offset(width * 0.32f, height * 0.42f), radius = 24f)
                    drawCircle(color = Color(0xFFF4B41A), center = Offset(width * 0.44f, height * 0.46f), radius = 22f)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Petit badge vert "Un même trajet, un coût partagé"
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(VertBadge)
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "Un même trajet, un coût partagé",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = VertFonce
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Titre de la section
            Text(
                text = "Moins de frais.\nPlus de sérénité.",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = TextBlack,
                lineHeight = 28.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Paragraphe explicatif
            Text(
                text = "Étudiants, élèves et chauffeurs : trouvez votre place sur le chemin des cours.",
                fontSize = 13.sp,
                color = TextGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Carte d'information dossier profil
            CovyInfoCard(
                icon = Icons.Outlined.Shield,
                title = "Un dossier pour chaque profil",
                description = "Carte scolaire ou documents chauffeur"
            )

            Spacer(modifier = Modifier.height(20.dp))
        }

        // Zone d'action fixe en bas
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Bouton vert principal : "Créer un compte"
            CovyButton(
                text = "Créer un compte",
                onClick = onNavigateToRegister
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Bouton lien : "J'ai déjà un compte - Se connecter"
            Text(
                text = "J'ai déjà un compte - Se connecter",
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
