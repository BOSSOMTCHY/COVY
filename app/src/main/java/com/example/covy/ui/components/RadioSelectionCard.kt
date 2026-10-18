package com.example.covy.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.ui.theme.*

/**
 * COMPOSANT : Carte de Sélection avec Bouton Radio
 * Permet à l'utilisateur de choisir parmi des options (ex: "Étudiant" vs "Élève").
 *
 * @param selected Si true, la carte affiche un fond vert clair et une bordure verte
 * @param onClick Action déclenchée au clic sur la carte
 * @param title Titre de la carte (ex: "Étudiant")
 * @param subtitle Sous-titre explicatif (ex: "Université ou enseignement supérieur")
 * @param description Description des éléments requis
 * @param selectedTagText Libellé du badge quand sélectionné (ex: "Sélectionné")
 */
@Composable
fun RadioSelectionCard(
    selected: Boolean,
    onClick: () -> Unit,
    title: String,
    subtitle: String,
    description: String,
    modifier: Modifier = Modifier,
    selectedTagText: String? = "Sélectionné"
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(if (selected) VertCovy.copy(alpha = 0.5f) else Color.White)
            .border(
                width = if (selected) 2.dp else 1.dp,
                color = if (selected) VertFonce else BordureCovy,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Radio Button personnalisé aux couleurs Covy
                RadioButton(
                    selected = selected,
                    onClick = onClick,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = VertFonce,
                        unselectedColor = TextMuted
                    )
                )

                Spacer(modifier = Modifier.width(8.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextBlack
                    )
                    Text(
                        text = subtitle,
                        fontSize = 12.sp,
                        color = TextGray
                    )
                }

                // Badge "Sélectionné" vert si sélectionné
                if (selected && selectedTagText != null) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(VertBadge)
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = selectedTagText,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = VertFonce
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Description des pièces requises
            Text(
                text = description,
                fontSize = 12.sp,
                color = TextGray,
                lineHeight = 16.sp,
                modifier = Modifier.padding(start = 40.dp)
            )
        }
    }
}
