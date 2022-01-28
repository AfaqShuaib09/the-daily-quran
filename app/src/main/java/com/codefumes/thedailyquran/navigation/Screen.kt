package com.codefumes.thedailyquran.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Qiblah : Screen("qiblah")
    object Prayer : Screen("prayer")
    object Tasbeeh : Screen("tasbeeh")
    object QuranView : Screen("quranView")
    object SupplicationsView : Screen("supplicationsView")
    object SingleSupplicationsView : Screen("singleSupplicationView")
}
