package com.example.thedailyquran.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontWeight
//import com.google.accompanist.systemuicontroller.rememberSystemUiController

@ExperimentalMaterial3Api
@Composable
fun TopBar() {
    val scrollBehavior = remember { TopAppBarDefaults.pinnedScrollBehavior() }
    //val systemUiController = rememberSystemUiController()
    //systemUiController.setSystemBarsColor(color = MaterialTheme.colorScheme.background)
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "The Daily Quran",
                fontWeight = FontWeight(900)
            )
        },
        navigationIcon = {
            Icon(
                Icons.Rounded.Menu,
                contentDescription = "Back",
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        scrollBehavior = scrollBehavior
    )
}