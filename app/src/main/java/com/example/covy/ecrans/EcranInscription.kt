package com.example.covy.ecrans

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.composants.*
import com.example.covy.ui.theme.*

// ===== ÉCRAN D'INSCRIPTION (création de compte) =====
@Composable
fun EcranInscription(
    onContinuer: () -> Unit,     // clic sur "Continuer"
    onRetour: () -> Unit         // flèche retour
) {
    var nom by remember { mutableStateOf("") }
    var telephone by remember { mutableStateOf("") }
    var motDePasse by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondCovy)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        BarreTitreCovy("Créer un compte", onRetour)
        Spacer(Modifier.height(8.dp))
        Text(
            "Rejoignez la communauté Covy",
            color = GrisCovy,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Spacer(Modifier.height(20.dp))

        CarteCovy {
            ChampCovy(nom, { nom = it }, "Nom complet")
            Spacer(Modifier.height(12.dp))
            ChampCovy(telephone, { telephone = it }, "Numéro de téléphone")
            Spacer(Modifier.height(12.dp))
            ChampCovy(motDePasse, { motDePasse = it }, "Mot de passe", motDePasse = true)
            Spacer(Modifier.height(20.dp))
            BoutonCovy("Continuer", onContinuer)
        }
    }
}