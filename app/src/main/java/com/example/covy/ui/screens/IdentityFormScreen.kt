package com.example.covy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.ui.components.*
import com.example.covy.ui.theme.*

/**
 * ÉCRAN 8 : Faisons Connaissance (Étape 07 / 30)
 *
 * Formulaire de saisie des informations personnelles (Prénom, Nom, Téléphone, Mot de passe).
 *
 * @param onNavigateBack Retour à l'écran précédent
 * @param onContinueToSchooling Continuer vers les détails de la scolarité (08/30 ou 09/30)
 */
@Composable
fun IdentityFormScreen(
    onNavigateBack: () -> Unit,
    onContinueToSchooling: () -> Unit
) {
    // États locaux pour stocker les saisies du formulaire
    var firstName by remember { mutableStateOf("Ashley") }
    var lastName by remember { mutableStateOf("Mensah") }
    var phoneNumber by remember { mutableStateOf("+225 07 01 23 45 67") }
    var password by remember { mutableStateOf("12345678") }
    var confirmPassword by remember { mutableStateOf("12345678") }
    var termsAccepted by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // En-tête avec étape "07 / 30"
        CovyHeader(
            stepText = "07 / 30",
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
                text = "INSCRIPTION • PASSAGER",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = TextGray,
                letterSpacing = 0.5.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Titre principal
            Text(
                text = "Faisons connaissance",
                fontSize = 26.sp,
                fontWeight = FontWeight.ExtraBold,
                color = TextBlack
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Sous-titre
            Text(
                text = "Vos informations pour créer votre compte.",
                fontSize = 13.sp,
                color = TextGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Barre de progression : "Identité - Étape 2 sur 4"
            StepProgressBar(
                title = "Identité - Étape 2 sur 4",
                currentStep = 2,
                totalSteps = 4
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Ligne : Prénom * et Nom * côte à côte
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    CovyTextField(
                        value = firstName,
                        onValueChange = { firstName = it },
                        label = "Prénom *"
                    )
                }
                Box(modifier = Modifier.weight(1f)) {
                    CovyTextField(
                        value = lastName,
                        onValueChange = { lastName = it },
                        label = "Nom *"
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Champ Numéro de Téléphone *
            CovyTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = "Téléphone *",
                trailingIcon = Icons.Outlined.Phone,
                keyboardType = KeyboardType.Phone
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Champ Mot de passe *
            CovyTextField(
                value = password,
                onValueChange = { password = it },
                label = "Mot de passe *",
                isPassword = true
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Indicatif des consignes de mot de passe
            Text(
                text = "8 caractères minimum, avec une lettre et un chiffre.",
                fontSize = 11.sp,
                color = TextMuted
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Champ Confirmer le mot de passe *
            CovyTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = "Confirmer le mot de passe *",
                isPassword = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Case à cocher pour les conditions d'utilisation
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Checkbox(
                    checked = termsAccepted,
                    onCheckedChange = { termsAccepted = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = VertFonce,
                        uncheckedColor = BordureCovy
                    )
                )
                Text(
                    text = "J'accepte les conditions d'utilisation de Covy.",
                    fontSize = 12.sp,
                    color = TextBlack
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Note champs obligatoires
            Text(
                text = "* Champs obligatoires",
                fontSize = 11.sp,
                color = TextMuted
            )

            Spacer(modifier = Modifier.height(24.dp))
        }

        // Zone d'action fixe au bas de la page
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp)
        ) {
            CovyButton(
                text = "Continuer vers la scolarité",
                onClick = onContinueToSchooling,
                enabled = termsAccepted && firstName.isNotBlank() && lastName.isNotBlank()
            )
        }
    }
}
