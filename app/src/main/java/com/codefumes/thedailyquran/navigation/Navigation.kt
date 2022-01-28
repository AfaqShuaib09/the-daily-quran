package com.codefumes.thedailyquran.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.codefumes.thedailyquran.layout.MainLayout
import com.codefumes.thedailyquran.pages.*
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@ExperimentalMaterial3Api
@Composable
fun TheDailyQuranApp(){
    val navController = rememberNavController();
    NavHost(navController = navController, startDestination = Screen.Home.route ){
        composable(route = Screen.Home.route){
            HomePage(navController = navController)
        }
        composable(route = Screen.Prayer.route){
            PrayerTimePage(navController = navController)
        }
        composable(route = Screen.Tasbeeh.route){
            TasbeehPage(navController = navController)
        }
        composable(route = Screen.QuranView.route + "?surahNo={surahNo}",
            arguments = listOf(navArgument("surahNo") { defaultValue = "1" }))
        {
            backStackEntry ->
            QuranView(
                navController = navController,
                surahNo = Integer.parseInt(backStackEntry.arguments?.getString("surahNo")))
        }
        composable(route = Screen.SurahView.route){
            SurahView(navController = navController)
        }
        composable(route = Screen.Qiblah.route){
            MainLayout(navController = navController) {

            }
        }
        composable(route = Screen.SupplicationsView.route){
            SupplicationsPage(navController = navController)
        }
        composable(route = Screen.SingleSupplicationsView.route + "?supplicationId={supplicationId}",
            arguments = listOf(navArgument("supplicationId") { defaultValue = "1" })
        ){
            backStackEntry ->
                SingleSupplicationPage(
                    navController = navController,
                    supplicationIndex = Integer.parseInt(backStackEntry.arguments?.getString("supplicationId")))
        }
    }
}