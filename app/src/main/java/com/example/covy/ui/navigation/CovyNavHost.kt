package com.example.covy.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.covy.ui.screens.*

/**
 * Gère le graphe de navigation entre les 5 écrans de l'application Covy.
 */
@Composable
fun CovyNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        modifier = modifier
    ) {
        // Écran 1 : Démarrage (Splash)
        composable(Screen.Splash.route) {
            SplashScreen(
                onNavigateToWelcome = {
                    navController.navigate(Screen.Welcome.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }

        // Écran 2 : Bienvenue (01 / 30)
        composable(Screen.Welcome.route) {
            WelcomeScreen(
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route)
                },
                onNavigateToRegister = {
                    // Route vers l'inscription
                    navController.navigate(Screen.Login.route)
                }
            )
        }

        // Écran 3 : Connexion (02 / 30)
        composable(Screen.Login.route) {
            LoginScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNavigateToForgotPassword = {
                    navController.navigate(Screen.ForgotPassword.route)
                },
                onNavigateToRegister = {
                    navController.navigate(Screen.Welcome.route)
                },
                onLoginSuccess = {
                    // Redirection après connexion réussie
                }
            )
        }

        // Écran 4 : Récupération de compte (03 / 30)
        composable(Screen.ForgotPassword.route) {
            ForgotPasswordScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onSendCodeSuccess = { _ ->
                    navController.navigate(Screen.OtpVerification.route)
                }
            )
        }

        // Écran 5 : Vérification SMS OTP (04 / 30)
        composable(Screen.OtpVerification.route) {
            OtpVerificationScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onVerifySuccess = {
                    // Code validé, retour à la connexion ou accueil
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Welcome.route)
                    }
                },
                onResendCode = {
                    // Renvoyer le SMS
                }
            )
        }
    }
}
