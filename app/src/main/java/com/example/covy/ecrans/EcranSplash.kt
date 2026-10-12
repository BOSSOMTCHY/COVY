package com.example.covy.ecrans

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.composants.LogoCovy
import com.example.covy.ui.theme.*
import kotlinx.coroutines.delay

// ===== ÉCRAN DE DÉMARRAGE (fond vert + logo) =====
@Composable
fun EcranSplash(onTermine: () -> Unit) {
    // Après 2 secondes, on passe à l'écran suivant
    LaunchedEffect(Unit) {
        delay(2000)
        onTermine()
    }

    Column(
        modifier = Modifier.fillMaxSize().background(VertCovy).padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LogoCovy(taille = 96.dp, couleurFond = Color.White, couleurLettre = VertFonce)
        Spacer(Modifier.height(16.dp))
        Text("Covy", fontSize = 40.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
        Spacer(Modifier.height(6.dp))
        Text("On campus, ensemble.", color = Color.White.copy(alpha = 0.9f), fontSize = 16.sp)
    }
}