package com.example.covy.ecrans

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.composants.*
import com.example.covy.ui.theme.*

// ===== ÉCRAN DE VÉRIFICATION PAR CODE (6 chiffres) =====
@Composable
fun EcranCodeOtp(
    onVerifie: () -> Unit,      // code complet validé
    onRetour: () -> Unit
) {
    var code by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondCovy)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        BarreTitreCovy("Vérification", onRetour)
        Spacer(Modifier.height(24.dp))

        CarteCovy {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LogoCovy(taille = 56.dp)
                Spacer(Modifier.height(16.dp))
                Text("Vérifiez votre compte", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = VertFonce)
                Spacer(Modifier.height(6.dp))
                Text("Entrez le code à 6 chiffres reçu par SMS", color = GrisCovy)
            }
            Spacer(Modifier.height(20.dp))

            // On accepte uniquement des chiffres, 6 maximum
            ChampCovy(
                valeur = code,
                onValeurChange = { if (it.length <= 6) code = it.filter(Char::isDigit) },
                libelle = "Code"
            )
            Spacer(Modifier.height(20.dp))
            // Le bouton reste grisé tant que les 6 chiffres ne sont pas saisis
            BoutonCovy("Vérifier", onVerifie, actif = code.length == 6)
        }
    }
}