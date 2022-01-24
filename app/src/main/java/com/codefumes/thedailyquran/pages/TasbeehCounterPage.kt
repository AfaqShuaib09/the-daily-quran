package com.codefumes.thedailyquran.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavHostController
import com.codefumes.thedailyquran.layout.MainLayout
import com.codefumes.thedailyquran.ui.theme.*
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.material.icons.rounded.*


@ExperimentalMaterial3Api
@Composable
fun TasbeehCounterPage(modifier: Modifier = Modifier, navController: NavHostController) {
    val currProg = remember { mutableStateOf(0.0) }
    MainLayout(navController = navController, content = {
        Column(
        ) {
            Surface(
                color = orange1,
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
                        Column() {
                            Column(
                            ) {
                                Text(
                                    text = "Zikr 1",
                                    style = MaterialTheme.typography.headlineLarge
                                )
                            }
                            Spacer(modifier.size(20.dp))
                            Column() {
                                Text(
                                    text = "Dua For This Goal:",
                                    style = MaterialTheme.typography.headlineMedium
                                )
                            }
                            Spacer(modifier.size(20.dp))
                            Text(
                                text = "رَبَّنَا ظَلَمْنَا أَنفُسَنَا وَإِن لَّمْ تَغْفِرْ لَنَا وَتَرْحَمْنَا لَنَكُونَنَّ مِنَ الْخَاسِرِينَ",
                                fontSize = 8.em,
                                fontFamily = NooreHudaFont,
                                lineHeight = 1.5.em,
                                textAlign = TextAlign.End
                            )
                            Spacer(modifier.size(20.dp))
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "${(currProg.value).toInt()}/45",
                                    style = MaterialTheme.typography.headlineSmall
                                )
                                LinearProgressIndicator(
                                    progress = (currProg.value / 45.0).toFloat(),
                                    color = Color.White,
                                    backgroundColor = Color.Transparent.copy(alpha = 0.1f)
                                )
                            }
                        }
                    }
                }
            }
            ElevatedButton(
                onClick = { currProg.value = currProg.value + 1 },
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Icon(Icons.Rounded.Add, contentDescription = "Increment")
            }
            ElevatedButton(
                onClick = { currProg.value = currProg.value + 1 },
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                //Icon(Icons.Rounded., contentDescription = "Increment")
            }
        }
    })
}