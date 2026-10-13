package com.example.covy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.covy.ui.navigation.CovyNavHost
import com.example.covy.ui.theme.CovyTheme

/**
 * Activité Principale (MainActivity)
 * Point d'entrée de l'application Android COVY.
 *
 * Charge le thème global 'CovyTheme' et le contrôleur de navigation 'CovyNavHost'.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Active l'affichage moderne Edge-to-Edge (barre de statut transparente)
        enableEdgeToEdge()

        setContent {
            // Application du thème aux couleurs officielles de Covy
            CovyTheme {
                // Structure de base de l'écran avec conteneur Scaffold
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Charge le graphe de navigation principal entre tous les écrans
                    CovyNavHost(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
