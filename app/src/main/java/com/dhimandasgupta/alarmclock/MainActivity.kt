package com.dhimandasgupta.alarmclock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.dhimandasgupta.alarmclock.ui.designsystem.AlarmClockTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val naController = rememberNavController()

            Scaffold(
                modifier = Modifier.fillMaxSize()
            ) { innerPadding ->
                AlarmClockTheme {
                    AlarmAppRoot(
                        navController = naController,
                        modifier = Modifier
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        colorScheme.primary,
                                        colorScheme.tertiary
                                    ),
                                    tileMode = TileMode.Repeated
                                )
                            )
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}