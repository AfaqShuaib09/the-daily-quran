package com.example.thedailyquran.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.NavigateNext
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thedailyquran.layout.MainLayout
import com.example.thedailyquran.ui.theme.*
import com.example.thedailyquran.R

@ExperimentalMaterial3Api
@Composable
fun PrayerTimePage(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    MainLayout() {
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            Spacer(modifier.size(20.dp))
            Surface(
            color = skin2,
            shape = RoundedCornerShape(15.dp),
            shadowElevation = 4.dp,
            contentColor = white,
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                color = Color.Transparent
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Spacer(modifier.size(20.dp))
                        Text(
                            text = "Prayers Time",
                            style = MaterialTheme.typography.headlineSmall
                        )
                        Spacer(modifier.size(12.dp))
                        Text(
                            text = "نماز کے اوقات",
                            style = MaterialTheme.typography.headlineSmall
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painterResource(id = R.drawable.nabawi_mosque),
                            contentDescription = "nabwi_mosque",
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .size(100.dp)
                        )
                    }
                }
            }
            }

        }
    }
}

