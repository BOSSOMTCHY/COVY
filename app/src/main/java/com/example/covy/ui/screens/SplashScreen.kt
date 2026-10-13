package com.example.covy.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.covy.ui.components.CovyLogo
import com.example.covy.ui.theme.TextBlack
import com.example.covy.ui.theme.TextGray
import com.example.covy.ui.theme.TextMuted
import kotlinx.coroutines.delay

/**
 * Écran 1 : Démarrage Covy (Splash)
 */
@Composable
fun SplashScreen(
    onNavigateToWelcome: () -> Unit
) {
    // Redirection automatique après 2.5 secondes
    LaunchedEffect(Unit) {
        delay(2500)
        onNavigateToWelcome()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onNavigateToWelcome() }
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            CovyLogo(
                iconSize = 160.dp,
                textSize = 48f
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Le campus, ensemble.",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = TextBlack,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Le covoiturage scolaire et universitaire à Abidjan.",
                fontSize = 14.sp,
                color = TextGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

        // Bas de page
        Text(
            text = "Élèves - Étudiants - Chauffeurs",
            fontSize = 12.sp,
            color = TextMuted,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        )
    }
}
