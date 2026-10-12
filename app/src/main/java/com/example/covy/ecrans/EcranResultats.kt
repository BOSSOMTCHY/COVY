package com.example.covy.ecrans

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.covy.composants.*
import com.example.covy.ui.theme.*

// ===== ÉCRAN DES RÉSULTATS DE RECHERCHE ("3 départs pour vous") =====
@Composable
fun EcranResultats(
    onRetour: () -> Unit,
    onChoisir: (Trajet) -> Unit      // clic sur un trajet
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondCovy)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        BarreTitreCovy("${trajetsExemple.size} départs pour vous", onRetour)
        Spacer(Modifier.height(8.dp))

        trajetsExemple.forEach { trajet ->
            CarteTrajet(trajet, onClick = { onChoisir(trajet) })
            Spacer(Modifier.height(12.dp))
        }
    }
}