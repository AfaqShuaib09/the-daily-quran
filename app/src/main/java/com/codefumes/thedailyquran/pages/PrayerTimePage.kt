package com.codefumes.thedailyquran.pages

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.codefumes.thedailyquran.layout.MainLayout
import com.codefumes.thedailyquran.ui.theme.*
import com.codefumes.thedailyquran.R
import java.text.SimpleDateFormat
import java.util.*

@ExperimentalMaterial3Api
@Composable
fun PrayerTimePage(modifier: Modifier = Modifier, navController: NavHostController) {
    val scrollState = rememberScrollState()
    val sdf = SimpleDateFormat("dd/MMM/yyyy")
    val currentDate = sdf.format(Date())
    val list = mutableListOf<Prayer>()
    val prayerName: Array<String> = arrayOf("Fajar", "Zuhr", "Asr", "Maghrib", "Esha")
    val prayerTime: Array<String> =
        arrayOf("5:30 A.M", "1:30 P.M", "3:30 P.M", "5:15 P.M", "6:45 P.M")
    for (i in 0 until 5) {
        list.add(Prayer(prayerName[i], prayerTime[i]))
    }
    MainLayout(navController = navController, content = {
        Column(
        ) {
            Surface(
                color = skin2,
                shape = RoundedCornerShape(15.dp),
                shadowElevation = 4.dp,
                contentColor = white,
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    skin1,
                                    skin3
                                )
                            )
                        )
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        color = Color.Transparent
                    ) {
                        Column(
                            modifier= Modifier.fillMaxWidth()
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Spacer(modifier.size(20.dp))
                                    Text(
                                        text = "Prayers Time",
                                        style = MaterialTheme.typography.headlineLarge
                                    )
                                    Spacer(modifier.size(12.dp))
                                    Text(
                                        text = "نماز کے اوقات",
                                        style = MaterialTheme.typography.headlineMedium
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
                            Spacer(modifier.size(15.dp))
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                    ) {
                                        Image(
                                            painterResource(id = R.drawable.ic_baseline_location_on_24),
                                            contentDescription = "loc",
                                            modifier = Modifier
                                                .padding(0.dp)
                                                .size(15.dp)
                                        )
                                        Text(
                                            text = "Lahore",
                                            style = MaterialTheme.typography.labelMedium
                                        )
                                    }
                                }
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(end=11.dp)
                                    ) {
                                        Image(
                                            painterResource(id = R.drawable.ic_baseline_date_range_24),
                                            contentDescription = "Date icon",
                                            modifier = Modifier
                                                .size(15.dp)
                                        )
                                        Text(
                                            text = currentDate,
                                            style = MaterialTheme.typography.labelMedium
                                        )
                                    }
                                }
                            }
                        }

                    }
                }
            }
            Spacer(modifier.size(25.dp))
            PrayersList(prayers = list)
        }

    }
    )
}

@Composable
fun PrayersList(
    prayers: List<Prayer>
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        prayers.forEach {
            prayer(prayer = it)
        }
    }
}

@Composable
fun prayer(
    prayer: Prayer
) {
    Surface(
        color = skin2,
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 4.dp,
        contentColor = white,
        modifier = Modifier.padding(bottom = 10.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = prayer.name,
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = prayer.time,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}


data class Prayer(val name: String, val time_: String) {
    val prayer: String = name;
    val time: String = time_;
}