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
 * Écran 2 : Bienvenue Covy (01 / 30)
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
        // En-tête avec étape 01 / 30
        CovyHeader(
            stepText = "01 / 30"
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 8.dp)
        ) {
            // Tag / Catégorie
            Text(
                text = "BIENVENUE • ABIDJAN",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = TextGray,
                letterSpacing = 0.5.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Titre Principal
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

            // Illustration représentative (Étudiants et voiture à Abidjan)
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

                    // Fond paysage
                    drawRect(color = Color(0xFFE8F5E9))

                    // Route
                    drawRect(
                        color = Color(0xFFD0E8D6),
                        topLeft = Offset(0f, height * 0.70f),
                        size = Size(width, height * 0.30f)
                    )

                    // Voiture verte
                    drawRoundRect(
                        color = VertFonce,
                        topLeft = Offset(width * 0.55f, height * 0.55f),
                        size = androidx.compose.ui.geometry.Size(width * 0.38f, height * 0.25f),
                        cornerRadius = CornerRadius(16f, 16f)
                    )

                    // Silhouettes des étudiants
                    drawCircle(color = Color(0xFF333333), center = Offset(width * 0.20f, height * 0.45f), radius = 22f)
                    drawCircle(color = Color(0xFF004D34), center = Offset(width * 0.32f, height * 0.42f), radius = 24f)
                    drawCircle(color = Color(0xFFF4B41A), center = Offset(width * 0.44f, height * 0.46f), radius = 22f)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Badge vert "Un même trajet, un coût partagé"
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

            // Titre section
            Text(
                text = "Moins de frais.\nPlus de sérénité.",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = TextBlack,
                lineHeight = 28.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Description
            Text(
                text = "Étudiants, élèves et chauffeurs : trouvez votre place sur le chemin des cours.",
                fontSize = 13.sp,
                color = TextGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Carte dossier profil
            CovyInfoCard(
                icon = Icons.Outlined.Shield,
                title = "Un dossier pour chaque profil",
                description = "Carte scolaire ou documents chauffeur"
            )

            Spacer(modifier = Modifier.height(20.dp))
        }

        // Zone d'action (Boutons au bas de l'écran)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CovyButton(
                text = "Créer un compte",
                onClick = onNavigateToRegister
            )

            Spacer(modifier = Modifier.height(12.dp))

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
