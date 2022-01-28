package com.codefumes.thedailyquran

import com.google.accompanist.pager.ExperimentalPagerApi
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.codefumes.thedailyquran.navigation.TheDailyQuranApp
import com.codefumes.thedailyquran.ui.theme.TheDailyQuranTheme

class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheDailyQuranTheme {
                TheDailyQuranApp()
            }
        }
    }
//    override fun onSensorChanged(sensorEvent: SensorEvent) {
//        val degree = Math.round(sensorEvent.values[0])
//        val animation = RotateAnimation(
//            currentDegrees,
//            (-degree).toFloat(), Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
//        )
//        animation.duration = 500
//        animation.fillAfter = true
//        Image(painter = R.drawable.qibla_compass, contentDescription = "compass")
//        ic_compass.setAnimation(animation)
//        currentDegrees = -degree
//    }
//
//    fun onAccuracyChanged(sensor: Sensor?, i: Int) {}
}

//@ExperimentalMaterial3Api
//@Composable
//fun TheDailyQuranApp() {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "tasbeeh") {
//        composable("home") { HomePage(navController = navController) }
//        composable("tasbeeh") { TasbeehPage(navController = navController) }
//        composable("prayerTime") { PrayerTimePage(navController = navController) }
//    }
//}

@ExperimentalPagerApi
@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TheDailyQuranTheme {
      TheDailyQuranApp()
    }
}