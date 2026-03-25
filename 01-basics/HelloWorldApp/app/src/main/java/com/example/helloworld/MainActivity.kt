package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.helloworld.ui.theme.HelloWorldAppTheme

/**
 * Entry point for the Hello World app.
 *
 * AI Prompt used (Panda / Gemini):
 * "Create a Jetpack Compose MainActivity that sets a HelloWorldAppTheme
 *  and displays a MainScreen composable."
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorldAppTheme {
                MainScreen()
            }
        }
    }
}
