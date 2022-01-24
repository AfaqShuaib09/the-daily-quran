package com.codefumes.thedailyquran.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Qiblah : Screen("qiblah")
    object Prayer : Screen("prayer")
    object TasbeehView : Screen("tasbeeh")
    object TasbeehGoals : Screen("tasbeehGoals")
    object QuranView : Screen("quranView")
    object TasbeehCounter : Screen("tasbeehCounter")
}
