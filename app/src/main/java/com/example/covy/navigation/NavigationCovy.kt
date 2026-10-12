package com.example.covy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.covy.ecrans.*

// ===== Gère les déplacements entre les écrans =====
@Composable
fun NavigationCovy() {
    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = Routes.SPLASH) {

        // Splash → Connexion (on retire le splash de l'historique)
        composable(Routes.SPLASH) {
            EcranSplash(onTermine = {
                nav.navigate(Routes.CONNEXION) { popUpTo(Routes.SPLASH) { inclusive = true } }
            })
        }

        // Connexion → Code OTP ou Inscription
        composable(Routes.CONNEXION) {
            EcranConnexion(
                onConnexion = { nav.navigate(Routes.CODE_OTP) },
                onInscription = { nav.navigate(Routes.INSCRIPTION) }
            )
        }

        // Inscription → Code OTP
        composable(Routes.INSCRIPTION) {
            EcranInscription(
                onContinuer = { nav.navigate(Routes.CODE_OTP) },
                onRetour = { nav.popBackStack() }
            )
        }

        // Code OTP → Accueil (on vide l'historique de connexion)
        composable(Routes.CODE_OTP) {
            EcranCodeOtp(
                onVerifie = {
                    nav.navigate(Routes.ACCUEIL) { popUpTo(Routes.CONNEXION) { inclusive = true } }
                },
                onRetour = { nav.popBackStack() }
            )
        }

        // Accueil → Résultats
        composable(Routes.ACCUEIL) {
            EcranAccueil(onRechercher = { nav.navigate(Routes.RESULTATS) })
        }

        // Résultats → (détail du trajet à venir)
        composable(Routes.RESULTATS) {
            EcranResultats(
                onRetour = { nav.popBackStack() },
                onChoisir = { /* écran détail à ajouter */ }
            )
        }
    }
}