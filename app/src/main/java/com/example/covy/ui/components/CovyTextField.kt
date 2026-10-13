package com.example.covy.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.ui.theme.*

/**
 * COMPOSANT : Champ de Saisie Texte Réutilisable (OutlinedTextField)
 * Gère le libellé au-dessus, les bordures arrondies, les icônes de fin (téléphone, etc.)
 * et le masquage/démasquage automatique si c'est un mot de passe.
 *
 * @param value Valeur actuelle du texte
 * @param onValueChange Callback appelé à chaque modification de saisie
 * @param label Libellé affiché au-dessus du champ (optionnel)
 * @param placeholder Texte d'exemple indicatif quand le champ est vide
 * @param isPassword Si true, masque les caractères et ajoute l'icône d'œil
 * @param leadingIcon Icône affichée au début du champ (optionnelle)
 * @param trailingIcon Icône affichée à la fin du champ (optionnelle)
 * @param keyboardType Type de clavier (Number, Phone, Password, Text...)
 */
@Composable
fun CovyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String = "",
    isPassword: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    // État local pour gérer la visibilité du mot de passe (Œil ouvert/fermé)
    var passwordVisible by remember { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxWidth()) {
        // Libellé au-dessus du champ de texte
        if (label != null) {
            Text(
                text = label,
                color = TextBlack,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 6.dp)
            )
        }

        // Champ de saisie borduré
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(Color.White),
            placeholder = {
                Text(
                    text = placeholder,
                    color = TextMuted,
                    fontSize = 14.sp
                )
            },
            // Icône de début (optionnelle)
            leadingIcon = if (leadingIcon != null) {
                {
                    Icon(
                        imageVector = leadingIcon,
                        contentDescription = null,
                        tint = TextGray,
                        modifier = Modifier.size(20.dp)
                    )
                }
            } else null,
            // Icône de fin : Bouton Œil pour mot de passe OU icône fixe (ex: téléphone)
            trailingIcon = if (isPassword) {
                {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = if (passwordVisible) "Masquer le mot de passe" else "Afficher le mot de passe",
                            tint = TextGray,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            } else if (trailingIcon != null) {
                {
                    Icon(
                        imageVector = trailingIcon,
                        contentDescription = null,
                        tint = TextGray,
                        modifier = Modifier.size(20.dp)
                    )
                }
            } else null,
            // Transformation visuelle : Masquage en puces (••••) si c'est un mot de passe
            visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                keyboardType = if (isPassword) KeyboardType.Password else keyboardType
            ),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = VertFonce,
                unfocusedBorderColor = BordureCovy,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                cursorColor = VertFonce,
                focusedTextColor = TextBlack,
                unfocusedTextColor = TextBlack
            ),
            shape = RoundedCornerShape(14.dp)
        )
    }
}
