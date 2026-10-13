package com.example.covy.ui.navigation

/**
 * NAVIGATION : Définition de la liste complète des routes (écrans) de l'application Covy.
 *
 * Chaque objet correspond à un écran unique dans le graphe de navigation Jetpack Compose.
 */
sealed class Screen(val route: String) {
    // Écran 1 : Démarrage / Splash screen
    object Splash : Screen("splash")

    // Écran 2 : Bienvenue (Étape 01 / 30)
    object Welcome : Screen("welcome")

    // Écran 3 : Connexion au compte (Étape 02 / 30)
    object Login : Screen("login")

    // Écran 4 : Récupération de compte / Mot de passe oublié (Étape 03 / 30)
    object ForgotPassword : Screen("forgot_password")

    // Écran 5 : Vérification par code SMS (Étape 04 / 30)
    object OtpVerification : Screen("otp_verification")

    // Écran 6 : Choix du parcours étudiant (Étape 05 / 30)
    object StudentPathway : Screen("student_pathway")

    // Écran 7 : Choix du profil Étudiant ou Élève (Étape 06 / 30)
    object PassengerRole : Screen("passenger_role")

    // Écran 8 : Formulaire d'identité / Faisons connaissance (Étape 07 / 30)
    object IdentityForm : Screen("identity_form")

    // Écran 9 : Vie de campus pour les Étudiants (Étape 08 / 30)
    object CampusLife : Screen("campus_life")

    // Écran 10 : Établissement scolaire pour les Élèves (Étape 09 / 30)
    object SchoolLife : Screen("school_life")
}
