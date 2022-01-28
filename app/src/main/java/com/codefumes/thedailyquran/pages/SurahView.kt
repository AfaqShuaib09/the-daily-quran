package com.codefumes.thedailyquran.pages

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.codefumes.thedailyquran.data.Surah
import com.codefumes.thedailyquran.layout.MainLayout
import com.codefumes.thedailyquran.ui.theme.*


@ExperimentalMaterial3Api
@Composable
fun SurahView(modifier: Modifier = Modifier, navController: NavHostController) {
    var surahNamesList = com.codefumes.thedailyquran.data.Quran

    MainLayout(navController = navController, content = {
        LazyColumn(
        ) {
            item {
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
                                    horizontalArrangement = Arrangement.Center,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Column(
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Spacer(modifier.size(20.dp))
                                        Text(
                                            text = "Holy Quran",
                                            style = MaterialTheme.typography.headlineLarge
                                        )
                                        Spacer(modifier.size(8.dp))
                                        Text(
                                            text = "تِلۡکَ اٰیٰتُ الۡکِتٰبِ الۡمُبِیۡنِ۟",
                                            style = MaterialTheme.typography.headlineMedium,
                                            fontFamily = NooreHudaFont,
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
                Spacer(modifier.size(25.dp))
            }
            items(surahNamesList.size) {
                surahName->
                    SurahNameTile(surah = surahNamesList[surahName], navController = navController, surahNo = surahNamesList[surahName].id)
            }
        }
    })
}

@Composable
fun SurahNameTile(
    surah: Surah,
    navController: NavHostController,
    surahNo: Int
) {
    Surface(
        color = bgLight,
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 4.dp,
        contentColor = white,
        modifier = Modifier.padding(bottom = 10.dp).clickable(onClick = { navController.navigate("quranView?surahNo=$surahNo") })
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                color = skin3,
                text = surah.titleEnglish,
                style = MaterialTheme.typography.labelLarge,
            )
            Text(
                color = black,
                text = surah.titleArabic,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}
