package com.example.covy.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.ui.theme.VertFonce

/**
 * COMPOSANT : Bouton Principal Arrondi (Pill Button)
 * Bouton vert foncé (`VertFonce`) avec bords très arrondis et texte blanc en gras.
 *
 * Exemples :
 * - "Créer un compte"
 * - "Se connecter"
 * - "Envoyer le code SMS"
 * - "Vérifier le code"
 *
 * @param text Libellé affiché au centre du bouton
 * @param onClick Action déclenchée au clic
 * @param enabled État activé/désactivé du bouton
 * @param containerColor Couleur de fond du bouton (VertFonce par défaut)
 * @param contentColor Couleur du texte/contenu (Blanc par défaut)
 */
@Composable
fun CovyButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    containerColor: Color = VertFonce,
    contentColor: Color = Color.White
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp),
        shape = RoundedCornerShape(26.dp), // Arrondi complet style pilule
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        Text(
            text = text,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
