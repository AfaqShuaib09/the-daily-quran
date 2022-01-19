package com.example.thedailyquran.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Qiblah : Screen("qiblah")
    object Prayer : Screen("prayer")
    object Tasbeeh : Screen("tasbeeh")
}
