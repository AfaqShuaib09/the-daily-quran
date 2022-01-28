package com.codefumes.thedailyquran.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.ArrowRight
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.codefumes.thedailyquran.layout.MainLayout
import com.codefumes.thedailyquran.ui.theme.white
import com.codefumes.thedailyquran.R
import com.codefumes.thedailyquran.components.QuranVerse
import com.codefumes.thedailyquran.data.getAllSurahs
import com.codefumes.thedailyquran.ui.theme.NooreHudaFont
import com.codefumes.thedailyquran.ui.theme.QuranVerseDivider
import com.codefumes.thedailyquran.ui.theme.skin1

@ExperimentalMaterial3Api
@Composable
fun QuranView(modifier: Modifier = Modifier, navController: NavHostController, surahNo: Int) {
    val scrollState = rememberScrollState()
    val surahData = com.codefumes.thedailyquran.data.Quran[surahNo-1]
    val (openDialog, setOpenDialog) = remember { mutableStateOf(false) }

    MainLayout (navController = navController) {
        LazyColumn (
        ) {
            item(){
                Spacer(modifier.size(20.dp))
                Surface(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(25.dp),
                    shadowElevation = 4.dp,
                    contentColor = white,
                ) {
                    Box(
                        modifier = Modifier.background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFFF89B70),
                                    Color(0xFFF57E86)
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
                            Row (
                                horizontalArrangement = Arrangement.SpaceBetween
                            ){
                                Column() {
                                    Text(
                                        text = surahData.titleEnglish,
                                        style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.ExtraBold),
                                    )
                                    Spacer(modifier.size(8.dp))
                                    Text(
                                        text = surahData.titleMeaningEnglish,
                                        style = MaterialTheme.typography.headlineSmall,
                                    )
                                    Spacer(modifier.size(34.dp))
                                    Text(
                                        text = surahData.verses.size.toString() + " Verses",
                                        style = MaterialTheme.typography.bodyLarge,
                                    )
                                    Spacer(modifier.size(8.dp))
                                    Text(
                                        text = "Nazool " + surahData.nazool,
                                        style = MaterialTheme.typography.bodyLarge,
                                    )
                                }
                                Column(
                                    horizontalAlignment = Alignment.End
                                ) {
                                    Text(
                                        text = surahData.titleArabic,
                                        style = MaterialTheme.typography.headlineLarge.copy(
                                            fontFamily = NooreHudaFont,
                                            fontSize = 13.em
                                        ),
                                    )
                                }
                            }
                        }
                    }
                }
//                Spacer(modifier.size(20.dp))
//                Button(
//                    onClick = {
//                        setOpenDialog(true)
//                    },
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically,
//                        modifier = Modifier.padding(vertical = 8.dp)
//                    ) {
//                        Text(text = "Learn About This Surah ", style = MaterialTheme.typography.headlineSmall)
//                        Icon(Icons.Rounded.ArrowForwardIos , contentDescription = null, tint = white, modifier = Modifier.size(22.dp))
//                    }
//                }
                Spacer(modifier.size(35.dp))
                QuranVerseDivider()
            }
            items(surahData.verses.size) { index ->
                QuranVerse(verse = surahData.verses[index])
            }
            item() {
                Spacer(modifier.size(20.dp))
                Button(
                    onClick = {
                        setOpenDialog(true)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        Text(text = "Next Surah ", style = MaterialTheme.typography.headlineSmall)
                        Icon(Icons.Rounded.ArrowForwardIos , contentDescription = null, tint = white,
                            modifier = Modifier.size(22.dp).clickable { navController.navigate("quranView?surahNo="+surahNo+1) }
                        )
                    }
                }
            }
        }

//        verse info dialog
        if(openDialog) {
            var dialogScrollState = rememberScrollState()
            AlertDialog(
                onDismissRequest = { /*TODO*/ },
                title = { Text(text = "سورۃ کا پس منظر", textAlign = TextAlign.Center) },
                text = { Column(
                    modifier = Modifier.verticalScroll(dialogScrollState).height(500.dp)
                ) {
                    Text(text = surahData.info, fontSize = 4.em)
                }},
                confirmButton = {},
                dismissButton = {
                    Button(
                        onClick = {
                            setOpenDialog(false)
                        }) {
                        Text("Dismiss")
                    }
                }
            )
        }
    }
}

