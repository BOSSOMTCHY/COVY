package com.example.covy.composants

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.ui.theme.*

// ===== MODÈLE DE DONNÉES : un trajet =====
data class Trajet(
    val depart: String,
    val arrivee: String,
    val heure: String,
    val prix: Int,           // en FCFA
    val places: Int,         // places disponibles
    val conducteur: String
)

// ===== DONNÉES D'EXEMPLE (à remplacer plus tard par de vraies données) =====
val trajetsExemple = listOf(
    Trajet("Campus", "Bingerville", "17:30", 1000, 3, "Kouassi A."),
    Trajet("Campus", "Plateau", "18:00", 1500, 2, "Awa T."),
    Trajet("Campus", "Yopougon", "18:15", 1200, 1, "Yao M.")
)

// ===== CARTE D'UN TRAJET (cliquable) =====
@Composable
fun CarteTrajet(trajet: Trajet, onClick: () -> Unit) {
    CarteCovy(modifier = Modifier.clip(RoundedCornerShape(20.dp)).clickable { onClick() }) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Colonne de gauche : heure, itinéraire, conducteur
            Column(Modifier.weight(1f)) {
                Text(trajet.heure, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = VertFonce)
                Spacer(Modifier.height(4.dp))
                Text("${trajet.depart} → ${trajet.arrivee}", fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.height(2.dp))
                Text("${trajet.conducteur} · ${trajet.places} place(s)", color = GrisCovy, fontSize = 13.sp)
            }
            // À droite : le prix
            Text("${trajet.prix} FCFA", fontWeight = FontWeight.Bold, color = VertCovy, fontSize = 16.sp)
        }
    }
}