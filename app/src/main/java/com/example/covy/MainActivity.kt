package com.example.covy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.covy.navigation.NavigationCovy
import com.example.covy.ui.theme.ThemeCovy

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Le thème enveloppe toute la navigation de l'application
        setContent {
            ThemeCovy {
                NavigationCovy()
            }
        }
    }
}