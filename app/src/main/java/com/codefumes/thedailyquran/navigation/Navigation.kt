package com.codefumes.thedailyquran.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.codefumes.thedailyquran.layout.MainLayout
import com.codefumes.thedailyquran.pages.*

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

        composable(route = Screen.QuranView.route){
            QuranView(navController = navController)
        }
        composable(route = Screen.Qiblah.route){
            MainLayout(navController = navController) {

            }
        }
        navigation(startDestination = Screen.TasbeehGoals.route, route= Screen.TasbeehView.route){
            composable(route = Screen.TasbeehGoals.route){
                TasbeehPage(navController = navController)
            }
            composable(route = Screen.TasbeehCounter.route){
                TasbeehCounterPage(navController = navController)
            }
        }
    }
}