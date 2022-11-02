package edu.ucne.parcial2_anderson.ui.navigation

sealed class Screen(val route: String){
    object HomeScreen: Screen("Home")
    object VerboList: Screen("VerboList")
}