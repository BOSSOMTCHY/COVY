package com.example.covy.ecrans

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.composants.*
import com.example.covy.ui.theme.*

// ===== ÉCRAN D'ACCUEIL =====
@Composable
fun EcranAccueil(onRechercher: () -> Unit) {
    var depart by remember { mutableStateOf("") }
    var arrivee by remember { mutableStateOf("") }
    var ongletChoisi by remember { mutableIntStateOf(0) }   // onglet actif de la barre du bas

    // Les 4 onglets de la barre de navigation du bas
    val onglets = listOf(
        "Accueil" to Icons.Default.Home,
        "Recherche" to Icons.Default.Search,
        "Trajets" to Icons.Default.DateRange,
        "Profil" to Icons.Default.Person
    )

    Scaffold(
        containerColor = FondCovy,
        // ----- Barre de navigation du bas -----
        bottomBar = {
            NavigationBar(containerColor = Color.White) {
                onglets.forEachIndexed { index, (nom, icone) ->
                    NavigationBarItem(
                        selected = ongletChoisi == index,
                        onClick = { ongletChoisi = index },
                        icon = { Icon(icone, contentDescription = nom) },
                        label = { Text(nom) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White,
                            indicatorColor = VertFonce,
                            selectedTextColor = VertFonce
                        )
                    )
                }
            }
        }
    ) { marges ->
        // ----- Contenu de l'écran -----
        Column(
            modifier = Modifier
                .padding(marges)
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            Text("Bonjour 👋", fontSize = 26.sp, fontWeight = FontWeight.Bold, color = VertFonce)
            Text("Où allez-vous aujourd'hui ?", color = GrisCovy)
            Spacer(Modifier.height(20.dp))

            // Carte "Votre prochain départ" (fond vert foncé)
            CarteCovy(couleurFond = VertFonce) {
                Text("Votre prochain départ", color = Color.White.copy(alpha = 0.8f), fontSize = 13.sp)
                Spacer(Modifier.height(6.dp))
                Text("Campus → Bingerville", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(4.dp))
                Text("Aujourd'hui · 17:30", color = VertCovy, fontWeight = FontWeight.SemiBold)
            }

            Spacer(Modifier.height(16.dp))

            // Carte de recherche
            CarteCovy {
                Text("Rechercher un trajet", fontWeight = FontWeight.SemiBold, color = VertFonce)
                Spacer(Modifier.height(12.dp))
                ChampCovy(depart, { depart = it }, "Départ")
                Spacer(Modifier.height(10.dp))
                ChampCovy(arrivee, { arrivee = it }, "Arrivée")
                Spacer(Modifier.height(16.dp))
                BoutonCovy("Rechercher", onRechercher)
            }

            Spacer(Modifier.height(24.dp))
            Text("Départs populaires", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = VertFonce)
            Spacer(Modifier.height(12.dp))

            // Liste des trajets d'exemple
            trajetsExemple.forEach { trajet ->
                CarteTrajet(trajet, onClick = onRechercher)
                Spacer(Modifier.height(10.dp))
            }
        }
    }
}