package com.example.covy.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.ui.theme.BordureCovy
import com.example.covy.ui.theme.TextBlack
import com.example.covy.ui.theme.VertFonce

/**
 * COMPOSANT : Grille de Saisie de Code SMS (OTP) à 6 Chiffres
 * Affiche 6 cases individuelles arrondies. Chaque case contient 1 chiffre.
 *
 * @param otpText Le code saisi actuellement (ex: "382916")
 * @param onOtpTextChange Callback déclenché à chaque modification du code
 * @param otpLength Nombre total de chiffres requis (6 par défaut)
 */
@Composable
fun OtpInputField(
    otpText: String,
    onOtpTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    otpLength: Int = 6
) {
    // Champ de texte invisible de base servant à capturer la saisie clavier numérique
    BasicTextField(
        value = otpText,
        onValueChange = {
            // Seuls les chiffres sont acceptés et la longueur ne dépasse pas 6
            if (it.length <= otpLength && it.all { char -> char.isDigit() }) {
                onOtpTextChange(it)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = modifier.fillMaxWidth(),
        decorationBox = {
            // Affichage visuel sous forme de 6 carrés/cases
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                repeat(otpLength) { index ->
                    // Récupère le chiffre correspondant à cette position
                    val char = when {
                        index < otpText.length -> otpText[index].toString()
                        else -> ""
                    }
                    // Détermine si cette case est la case actuellement ciblée (Focus)
                    val isFocused = otpText.length == index

                    // Dessin du carré individuel de la case
                    Box(
                        modifier = Modifier
                            .width(48.dp)
                            .height(56.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White)
                            .border(
                                width = if (isFocused) 2.dp else 1.dp,
                                color = if (isFocused) VertFonce else BordureCovy,
                                shape = RoundedCornerShape(12.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = char,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextBlack,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    )
}
