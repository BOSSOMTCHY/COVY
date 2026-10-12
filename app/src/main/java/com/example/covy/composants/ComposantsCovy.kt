package com.example.covy.composants

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.ui.theme.*

// ===== BOUTON PRINCIPAL (vert foncé, arrondi) =====
@Composable
fun BoutonCovy(
    texte: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    actif: Boolean = true          // false = bouton grisé
) {
    Button(
        onClick = onClick,
        enabled = actif,
        modifier = modifier.fillMaxWidth().height(54.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = VertFonce,
            contentColor = Color.White,
            disabledContainerColor = BordureCovy
        )
    ) {
        Text(texte, fontWeight = FontWeight.SemiBold)
    }
}

// ===== CHAMP DE SAISIE (email, nom, mot de passe...) =====
@Composable
fun ChampCovy(
    valeur: String,
    onValeurChange: (String) -> Unit,
    libelle: String,                    // texte affiché dans le champ
    modifier: Modifier = Modifier,
    motDePasse: Boolean = false         // true = caractères masqués
) {
    OutlinedTextField(
        value = valeur,
        onValueChange = onValeurChange,
        label = { Text(libelle) },
        singleLine = true,
        visualTransformation = if (motDePasse) PasswordVisualTransformation() else VisualTransformation.None,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = VertCovy,
            unfocusedBorderColor = BordureCovy,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        )
    )
}

// ===== LOGO ROND AVEC LA LETTRE "C" =====
@Composable
fun LogoCovy(
    taille: Dp = 80.dp,
    couleurFond: Color = VertFonce,
    couleurLettre: Color = Color.White
) {
    Box(
        modifier = Modifier.size(taille).clip(CircleShape).background(couleurFond),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "C",
            color = couleurLettre,
            fontSize = (taille.value * 0.5f).sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

// ===== CARTE BLANCHE ARRONDIE (conteneur générique) =====
@Composable
fun CarteCovy(
    modifier: Modifier = Modifier,
    couleurFond: Color = Color.White,
    contenu: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = couleurFond),
        border = BorderStroke(1.dp, BordureCovy)
    ) {
        Column(Modifier.padding(16.dp), content = contenu)
    }
}

// ===== BARRE DE TITRE AVEC FLÈCHE RETOUR =====
@Composable
fun BarreTitreCovy(
    titre: String,
    onRetour: (() -> Unit)? = null      // null = pas de flèche retour
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (onRetour != null) {
            IconButton(onClick = onRetour) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Retour")
            }
        }
        Text(titre, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = VertFonce)
    }
}