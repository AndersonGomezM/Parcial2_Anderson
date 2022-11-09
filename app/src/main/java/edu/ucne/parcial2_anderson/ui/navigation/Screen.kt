package edu.ucne.parcial2_anderson.ui.navigation

sealed class Screen(val route: String){
    object VerbosListScreen: Screen("VerboList")
}