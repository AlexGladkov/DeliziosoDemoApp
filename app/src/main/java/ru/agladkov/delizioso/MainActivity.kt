package ru.agladkov.delizioso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import ru.agladkov.delizioso.ui.screens.ApplicationScreen
import ru.agladkov.delizioso.ui.theme.AppTheme
import ru.agladkov.delizioso.ui.theme.DeliziosoTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DeliziosoTheme {
                val systemUiController = rememberSystemUiController()

                // Set status bar color
                val primaryBackground = AppTheme.colors.primaryBackground
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = primaryBackground,
                        darkIcons = true
                    )
                }

                ApplicationScreen()
            }
        }
    }
}