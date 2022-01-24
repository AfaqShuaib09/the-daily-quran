package com.codefumes.thedailyquran.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.codefumes.thedailyquran.R
import com.codefumes.thedailyquran.layout.MainLayout
import com.codefumes.thedailyquran.ui.theme.skin1
import com.codefumes.thedailyquran.ui.theme.skin2
import com.codefumes.thedailyquran.ui.theme.skin3
import com.codefumes.thedailyquran.ui.theme.white
import java.text.SimpleDateFormat
import java.util.*

@ExperimentalMaterial3Api
@Composable
fun SupplicationsPage(modifier: Modifier = Modifier, navController: NavHostController) {
    val scrollState = rememberScrollState()
    val sdf = SimpleDateFormat("dd/MMM/yyyy")
    val currentDate = sdf.format(Date())
    val list = mutableListOf<Supplication>()
    val prayerName: Array<String> = arrayOf("Fajar", "Zuhr", "Asr", "Maghrib", "Esha")
    val prayerTime: Array<String> =
        arrayOf("5:30 A.M", "1:30 P.M", "3:30 P.M", "5:15 P.M", "6:45 P.M")
    for (i in 0 until 5) {
        list.add(Supplication(prayerName[i], prayerTime[i]))
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
                                        text = "Supplications Time",
                                        style = MaterialTheme.typography.headlineLarge
                                    )
                                    Spacer(modifier.size(12.dp))
                                    Text(
                                        text = "نماز کے اوقات",
                                        style = MaterialTheme.typography.headlineLarge
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
            SupplicationList(supplications = list)
        }

    }
    )
}

@Composable
fun SupplicationList(
    supplications: List<Supplication>
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        supplications.forEach {
            supplication(supplication = it)
        }
    }
}

@Composable
fun supplication(
    supplication: Supplication
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
                text = supplication.name,
                style = MaterialTheme.typography.headlineSmall,
                //modifier = Modifier.padding(horizontal = 10.dp)
            )
            Text(
                text = supplication.time,
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}


data class Supplication(val name: String, val time_: String) {
    val supplication: String = name;
    val time: String = time_;
}