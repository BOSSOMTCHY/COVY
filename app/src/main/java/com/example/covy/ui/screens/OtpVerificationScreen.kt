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
 * ÉCRAN 5 : Vérification SMS OTP Covy (04 / 30)
 *
 * Écran de saisie du code à 6 chiffres reçu par SMS.
 * Propose une grille de 6 cases numérotées et la possibilité de renvoyer le code.
 *
 * @param phoneNumber Numéro vers lequel le SMS a été envoyé
 * @param onNavigateBack Action pour modifier le numéro ou revenir en arrière
 * @param onVerifySuccess Validation du code SMS
 * @param onResendCode Action pour renvoyer le SMS
 */
@Composable
fun OtpVerificationScreen(
    phoneNumber: String = "+225 07 01 23 45 67",
    onNavigateBack: () -> Unit,
    onVerifySuccess: () -> Unit,
    onResendCode: () -> Unit
) {
    // Code à 6 chiffres saisi par l'utilisateur (pré-rempli avec 382916 d'après la maquette)
    var otpCode by remember { mutableStateOf("382916") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // En-tête avec flèche retour et étape "04 / 30"
        CovyHeader(
            stepText = "04 / 30",
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
                text = "ACCÈS • VÉRIFICATION",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = TextGray,
                letterSpacing = 0.5.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Titre principal
            Text(
                text = "Vérifiez votre numéro",
                fontSize = 26.sp,
                fontWeight = FontWeight.ExtraBold,
                color = TextBlack
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Sous-titre avec masque du numéro
            Text(
                text = "Code envoyé au $phoneNumber.",
                fontSize = 13.sp,
                color = TextGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Carte d'information consigne SMS
            CovyInfoCard(
                icon = Icons.Outlined.Sms,
                title = "Consultez vos SMS",
                description = "Saisissez les 6 chiffres reçus pour continuer."
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Libellé de la saisie OTP
            Text(
                text = "Code de vérification",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextBlack,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Grille de saisie à 6 cases numérotées
            OtpInputField(
                otpText = otpCode,
                onOtpTextChange = { otpCode = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Bloc "Vous n'avez pas reçu de code ? Renvoyer le code"
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

        // Zone d'action fixe en bas
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Bouton principal "Vérifier le code" (Actif seulement si 6 chiffres sont saisis)
            CovyButton(
                text = "Vérifier le code",
                onClick = onVerifySuccess,
                enabled = otpCode.length == 6
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Lien "Modifier le numéro" -> Retourne à l'étape précédente
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
