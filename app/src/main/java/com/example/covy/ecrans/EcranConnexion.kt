package com.example.covy.ecrans

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.composants.*
import com.example.covy.ui.theme.*

// ===== ÉCRAN DE CONNEXION ("Bon retour !") =====
@Composable
fun EcranConnexion(
    onConnexion: () -> Unit,       // clic sur "Se connecter"
    onInscription: () -> Unit      // clic sur "Créer un compte"
) {
    // Valeurs saisies par l'utilisateur
    var identifiant by remember { mutableStateOf("") }
    var motDePasse by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondCovy)
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(48.dp))
        LogoCovy(taille = 64.dp)
        Spacer(Modifier.height(24.dp))
        Text("Bon retour !", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = VertFonce)
        Spacer(Modifier.height(6.dp))
        Text("Connectez-vous pour retrouver vos trajets", color = GrisCovy)
        Spacer(Modifier.height(32.dp))

        // Carte contenant le formulaire
        CarteCovy {
            ChampCovy(identifiant, { identifiant = it }, "Email ou numéro")
            Spacer(Modifier.height(12.dp))
            ChampCovy(motDePasse, { motDePasse = it }, "Mot de passe", motDePasse = true)
            Spacer(Modifier.height(20.dp))
            BoutonCovy("Se connecter", onConnexion)
        }

        Spacer(Modifier.height(12.dp))
        TextButton(onClick = onInscription) {
            Text("Pas encore de compte ? Créer un compte", color = VertFonce)
        }
    }
}