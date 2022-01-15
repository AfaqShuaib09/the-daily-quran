package com.example.thedailyquran

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.thedailyquran.components.NavBar
import com.example.thedailyquran.components.TopBar
import com.example.thedailyquran.ui.theme.TheDailyQuranTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheDailyQuranTheme {
//                Surface(
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Column {
//                        TopBar()
//                        NavBar()
//                    }
//                }
                Scaffold(
                    topBar= {TopBar()},
                ) {
                    NavBar()
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TheDailyQuranTheme {
//                Surface(
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Column {
//                        TopBar()
//                        NavBar()
//                    }
//                }
        Scaffold(
            topBar= {TopBar()},
        ) {
            NavBar()
        }
    }
}