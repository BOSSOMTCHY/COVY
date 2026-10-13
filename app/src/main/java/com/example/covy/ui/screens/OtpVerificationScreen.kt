package com.example.covy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Sms
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.ui.components.*
import com.example.covy.ui.theme.*

/**
 * Écran 5 : Vérification SMS OTP Covy (04 / 30)
 */
@Composable
fun OtpVerificationScreen(
    phoneNumber: String = "+225 07 01 23 45 67",
    onNavigateBack: () -> Unit,
    onVerifySuccess: () -> Unit,
    onResendCode: () -> Unit
) {
    var otpCode by remember { mutableStateOf("382916") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // En-tête avec étape 04 / 30
        CovyHeader(
            stepText = "04 / 30",
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
                text = "ACCÈS • VÉRIFICATION",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = TextGray,
                letterSpacing = 0.5.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Titre
            Text(
                text = "Vérifiez votre numéro",
                fontSize = 26.sp,
                fontWeight = FontWeight.ExtraBold,
                color = TextBlack
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Sous-titre avec masque numéro
            Text(
                text = "Code envoyé au $phoneNumber.",
                fontSize = 13.sp,
                color = TextGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Carte d'information SMS
            CovyInfoCard(
                icon = Icons.Outlined.Sms,
                title = "Consultez vos SMS",
                description = "Saisissez les 6 chiffres reçus pour continuer."
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Label de la saisie
            Text(
                text = "Code de vérification",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextBlack,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Champs de saisie OTP (6 cases)
            OtpInputField(
                otpText = otpCode,
                onOtpTextChange = { otpCode = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Option "Renvoyer le code"
            Column(modifier = Modifier.padding(vertical = 4.dp)) {
                Text(
                    text = "Vous n'avez pas reçu de code ?",
                    fontSize = 12.sp,
                    color = TextGray
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Renvoyer le code",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = VertFonce,
                    modifier = Modifier.clickable { onResendCode() }
                )
            }

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
                text = "Vérifier le code",
                onClick = onVerifySuccess,
                enabled = otpCode.length == 6
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Modifier le numéro",
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
