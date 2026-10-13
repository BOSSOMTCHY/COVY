package com.example.covy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Key
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.ui.components.*
import com.example.covy.ui.theme.*

/**
 * Écran 3 : Connexion Covy (02 / 30)
 */
@Composable
fun LoginScreen(
    onNavigateBack: () -> Unit,
    onNavigateToForgotPassword: () -> Unit,
    onNavigateToRegister: () -> Unit,
    onLoginSuccess: () -> Unit
) {
    var phoneNumber by remember { mutableStateOf("+225 07 01 23 45 67") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // En-tête avec flèche retour et étape 02 / 30
        CovyHeader(
            stepText = "02 / 30",
            onBackClick = onNavigateBack
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
                text = "ACCÈS AU COMPTE",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = TextGray,
                letterSpacing = 0.5.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Titre
            Text(
                text = "Bon retour !",
                fontSize = 26.sp,
                fontWeight = FontWeight.ExtraBold,
                color = TextBlack
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Sous-titre
            Text(
                text = "Retrouvez vos trajets et votre espace Covy.",
                fontSize = 13.sp,
                color = TextGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Carte d'information avec clé
            CovyInfoCard(
                icon = Icons.Outlined.Key,
                title = "Votre compte, votre trajet.",
                description = "Utilisez le numéro associé à votre compte, que vous soyez passager ou chauffeur."
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Champ Numéro de Téléphone
            CovyTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = "Numéro de téléphone",
                placeholder = "+225 07 00 00 00 00",
                leadingIcon = null,
                trailingIcon = Icons.Outlined.Phone,
                keyboardType = KeyboardType.Phone
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Champ Mot de Passe
            CovyTextField(
                value = password,
                onValueChange = { password = it },
                label = "Mot de passe",
                placeholder = "••••••••",
                isPassword = true
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Lien Mot de passe oublié
            Text(
                text = "Mot de passe oublié ?",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = VertFonce,
                modifier = Modifier
                    .clickable { onNavigateToForgotPassword() }
                    .padding(vertical = 4.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))
        }

        // Zone d'action au bas de la page
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CovyButton(
                text = "Se connecter",
                onClick = onLoginSuccess
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Nouveau sur Covy ? Créer un compte",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = VertFonce,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clickable { onNavigateToRegister() }
                    .padding(8.dp)
            )
        }
    }
}
