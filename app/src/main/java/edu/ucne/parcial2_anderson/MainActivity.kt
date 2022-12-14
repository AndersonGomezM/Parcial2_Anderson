package edu.ucne.parcial2_anderson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.parcial2_anderson.ui.navigation.Screen
import edu.ucne.parcial2_anderson.ui.theme.Parcial2_AndersonTheme
import edu.ucne.parcial2_anderson.ui.verbos_list.VerbosListScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial2_AndersonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Inicio()
                }
            }
        }
    }
}

@Composable
fun Inicio() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.VerbosListScreen.route
    ) {
        composable(Screen.VerbosListScreen.route){
            VerbosListScreen()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Parcial2_AndersonTheme {

    }
}