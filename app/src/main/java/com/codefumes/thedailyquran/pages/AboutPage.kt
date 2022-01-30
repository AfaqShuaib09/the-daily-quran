package com.codefumes.thedailyquran.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.NavigateNext
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.codefumes.thedailyquran.R
import com.codefumes.thedailyquran.layout.EmptyLayout
import com.codefumes.thedailyquran.layout.MainLayout
import com.codefumes.thedailyquran.ui.theme.*

@ExperimentalMaterial3Api
@Composable
fun AboutPage(modifier: Modifier = Modifier, navController: NavHostController) {
    val scrollState = rememberScrollState()

    EmptyLayout(navController = navController, content = {
        Column(
            modifier = Modifier.verticalScroll(scrollState),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier.size(20.dp))
            Image(
                painterResource(id = R.drawable.logo),
                contentDescription = "quran_icon",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(100.dp)
            )
            Spacer(modifier.size(15.dp))
            Text(
                text = "The Daily Quran © 2022",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight(500)
            )
            Spacer(modifier.size(15.dp))
            Text(
                text = "This project is designed to facilitate the users who want to completely read the Holy Quran within a deadline by providing them verses and surahs daily and reminding them to read the Quran at their preferred time.",
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )
        }
    })
}