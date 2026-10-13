package com.example.covy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Smartphone
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
 * Écran 4 : Récupération de compte Covy (03 / 30)
 */
@Composable
fun ForgotPasswordScreen(
    onNavigateBack: () -> Unit,
    onSendCodeSuccess: (String) -> Unit
) {
    var phoneNumber by remember { mutableStateOf("+225 07 01 23 45 67") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // En-tête avec étape 03 / 30
        CovyHeader(
            stepText = "03 / 30",
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
                text = "ACCÈS • RÉCUPÉRATION",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = TextGray,
                letterSpacing = 0.5.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Titre
            Text(
                text = "Retrouvez votre compte",
                fontSize = 26.sp,
                fontWeight = FontWeight.ExtraBold,
                color = TextBlack
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Sous-titre
            Text(
                text = "Nous vous envoyons un code pour vérifier votre numéro.",
                fontSize = 13.sp,
                color = TextGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Carte d'information téléphone
            CovyInfoCard(
                icon = Icons.Outlined.Smartphone,
                title = "Un code à 6 chiffres",
                description = "Gardez votre téléphone à portée de main. Ne partagez jamais votre code."
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Champ Numéro de Téléphone
            CovyTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = "Téléphone associé au compte",
                placeholder = "+225 07 00 00 00 00",
                trailingIcon = Icons.Outlined.Phone,
                keyboardType = KeyboardType.Phone
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Message d'information
            Text(
                text = "Après vérification, vous pourrez définir un nouveau mot de passe.",
                fontSize = 12.sp,
                color = TextGray
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
                text = "Envoyer le code SMS",
                onClick = { onSendCodeSuccess(phoneNumber) }
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Retour à la connexion",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = VertFonce,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clickable { onNavigateBack() }
                    .padding(8.dp)
            )
        }
    }
}
