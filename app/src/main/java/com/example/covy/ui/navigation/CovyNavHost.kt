package com.example.covy.ui.navigation

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.covy.ui.screens.*

/**
 * NAVIGATION : Graphe de navigation principal de l'application Covy.
 *
 * Gère l'enchaînement de la totalité des 10 premiers écrans :
 * - Écran 1 : Splash Screen (Démarrage)
 * - Écran 2 : Bienvenue (01 / 30)
 * - Écran 3 : Connexion (02 / 30)
 * - Écran 4 : Récupération (03 / 30)
 * - Écran 5 : Vérification SMS (04 / 30)
 * - Écran 6 : Votre Parcours Étudiant (05 / 30)
 * - Écran 7 : Votre Scolarité / Profil (06 / 30)
 * - Écran 8 : Faisons Connaissance / Identité (07 / 30)
 * - Écran 9 : Vie de Campus / Étudiant (08 / 30)
 * - Écran 10 : Votre École / Élève (09 / 30)
 */
@Composable
fun CovyNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    // État global mémorisant si l'utilisateur a choisi "Étudiant" (true) ou "Élève" (false)
    var isStudentProfile by remember { mutableStateOf(true) }

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        modifier = modifier
    ) {
        // ====================================================================
        // ÉCRAN 1 : DÉMARRAGE (SPLASH SCREEN)
        // ====================================================================
        composable(Screen.Splash.route) {
            SplashScreen(
                onNavigateToWelcome = {
                    navController.navigate(Screen.Welcome.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }

        // ====================================================================
        // ÉCRAN 2 : BIENVENUE (01 / 30)
        // ====================================================================
        composable(Screen.Welcome.route) {
            WelcomeScreen(
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route)
                },
                onNavigateToRegister = {
                    navController.navigate(Screen.StudentPathway.route)
                }
            )
        }

        // ====================================================================
        // ÉCRAN 3 : CONNEXION (02 / 30)
        // ====================================================================
        composable(Screen.Login.route) {
            LoginScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNavigateToForgotPassword = {
                    navController.navigate(Screen.ForgotPassword.route)
                },
                onNavigateToRegister = {
                    navController.navigate(Screen.StudentPathway.route)
                },
                onLoginSuccess = {
                    navController.navigate(Screen.ForgotPassword.route)
                }
            )
        }

        // ====================================================================
        // ÉCRAN 4 : RÉCUPÉRATION DE COMPTE (03 / 30)
        // ====================================================================
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

        // ====================================================================
        // ÉCRAN 5 : VÉRIFICATION CODE SMS OTP (04 / 30)
        // ====================================================================
        composable(Screen.OtpVerification.route) {
            OtpVerificationScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onVerifySuccess = {
                    navController.navigate(Screen.StudentPathway.route)
                },
                onResendCode = { }
            )
        }

        // ====================================================================
        // ÉCRAN 6 : VOTRE PARCOURS ÉTUDIANT (05 / 30)
        // ====================================================================
        composable(Screen.StudentPathway.route) {
            StudentPathwayScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNavigateToPassengerRole = {
                    navController.navigate(Screen.PassengerRole.route)
                },
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route)
                }
            )
        }

        // ====================================================================
        // ÉCRAN 7 : VOTRE SCOLARITÉ / PROFIL (06 / 30)
        // ====================================================================
        composable(Screen.PassengerRole.route) {
            PassengerRoleScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onContinue = { isStudent ->
                    isStudentProfile = isStudent
                    navController.navigate(Screen.IdentityForm.route)
                }
            )
        }

        // ====================================================================
        // ÉCRAN 8 : FAISONS CONNAISSANCE / IDENTITÉ (07 / 30)
        // ====================================================================
        composable(Screen.IdentityForm.route) {
            IdentityFormScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onContinueToSchooling = {
                    // Si Étudiant -> Écran 9 (08/30 CampusLife), Si Élève -> Écran 10 (09/30 SchoolLife)
                    if (isStudentProfile) {
                        navController.navigate(Screen.CampusLife.route)
                    } else {
                        navController.navigate(Screen.SchoolLife.route)
                    }
                }
            )
        }

        // ====================================================================
        // ÉCRAN 9 : VIE DE CAMPUS / ÉTUDIANT (08 / 30)
        // ====================================================================
        composable(Screen.CampusLife.route) {
            CampusLifeScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onSubmitDossier = {
                    // Fin du parcours étudiant -> Retour à la connexion ou écran principal
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Welcome.route)
                    }
                }
            )
        }

        // ====================================================================
        // ÉCRAN 10 : VOTRE ÉCOLE / ÉLÈVE (09 / 30)
        // ====================================================================
        composable(Screen.SchoolLife.route) {
            SchoolLifeScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onContinueToContacts = {
                    // Fin de la saisie école élève -> Retour à la connexion ou écran suivant
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Welcome.route)
                    }
                }
            )
        }
    }
}
