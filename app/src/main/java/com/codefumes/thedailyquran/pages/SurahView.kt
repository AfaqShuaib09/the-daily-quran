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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.codefumes.thedailyquran.R
import com.codefumes.thedailyquran.layout.MainLayout
import com.codefumes.thedailyquran.ui.theme.*


@ExperimentalMaterial3Api
@Composable
fun SurahView(modifier: Modifier = Modifier, navController: NavHostController) {
    val list = mutableListOf<Surah>()
    val SurahName: Array<String> = arrayOf("Fajar", "Zuhr", "Asr", "Maghrib", "Esha")
    val SurahTime: Array<String> =
        arrayOf("5:30 A.M", "1:30 P.M", "3:30 P.M", "5:15 P.M", "6:45 P.M")
    for (i in 0 until 5) {
        list.add(Surah(SurahName[i], SurahTime[i]))
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
                            modifier = Modifier.fillMaxWidth()
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
                                        text = "Quran Surahs",
                                        style = MaterialTheme.typography.headlineLarge
                                    )
                                    Spacer(modifier.size(8.dp))
                                    Text(
                                        text = "Al Fatiyah",
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                    Spacer(modifier.size(8.dp))
                                    Text(
                                        text = "Ayah no 1",
                                        style = MaterialTheme.typography.bodySmall,
                                        fontStyle = FontStyle.Italic
                                    )
                                }
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Image(
                                        painterResource(id = R.drawable.quran__1_),
                                        contentDescription = "quran_icon",
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
            Spacer(modifier.size(25.dp))
            SurahList(surah = list)
        }
    })
}

@Composable
fun SurahList(
    surah: List<Surah>
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        surah.forEach {
            surah(surah = it)
        }
    }
}

@Composable
fun surah(
    surah: Surah
) {
    Surface(
        color = bgLight,
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
                color = skin3,
                text = surah.name,
                style = MaterialTheme.typography.labelMedium,
                //modifier = Modifier.padding(horizontal = 10.dp)
            )
            Text(
                color = black,
                text = surah.time,
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}


data class Surah(val name: String, val time_: String) {
    val prayer: String = name;
    val time: String = time_;
}
