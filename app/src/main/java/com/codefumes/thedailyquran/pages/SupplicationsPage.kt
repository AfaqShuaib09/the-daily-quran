package com.codefumes.thedailyquran.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.codefumes.thedailyquran.R
import com.codefumes.thedailyquran.data.Supplication
import com.codefumes.thedailyquran.data.getAllSupplications
import com.codefumes.thedailyquran.data.getSupplicationsCount
import com.codefumes.thedailyquran.layout.MainLayout
import com.codefumes.thedailyquran.ui.theme.skin1
import com.codefumes.thedailyquran.ui.theme.skin2
import com.codefumes.thedailyquran.ui.theme.skin3
import com.codefumes.thedailyquran.ui.theme.white

@ExperimentalMaterial3Api
@Composable
fun SupplicationsPage(modifier: Modifier = Modifier, navController: NavHostController) {
    val supplicationsDatabase = getAllSupplications()

    MainLayout(navController = navController, content = {
        LazyColumn(
        ) {
            item() {
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
                                            text = "Supplications",
                                            style = MaterialTheme.typography.headlineLarge
                                        )
                                        Spacer(modifier.size(12.dp))
                                        Text(
                                            text = "مسنون دعائں",
                                            style = MaterialTheme.typography.headlineLarge
                                        )
                                    }
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Image(
                                            painterResource(id = R.drawable.supplication_vector),
                                            contentDescription = "supplication_vector",
                                            modifier = Modifier
                                                .align(Alignment.CenterHorizontally)
                                                .size(100.dp)
                                        )
                                    }
                                }
                                Spacer(modifier.size(15.dp))
                            }

                        }
                    }
                }
                Spacer(modifier.size(25.dp))
            }
            items(getSupplicationsCount()) {
                index -> SupplicationTile(supplication = supplicationsDatabase[index], navController = navController, index=index)
            }
        }

    }
    )
}

@Composable
fun SupplicationTile(
    supplication: Supplication,
    navController: NavHostController,
    index: Int = 0
) {
    Surface(
        color = skin2,
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 4.dp,
        contentColor = white,
        modifier = Modifier.padding(bottom = 10.dp).clickable(onClick = { navController.navigate("singleSupplicationView?supplicationId=$index") })
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = supplication.title,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Right,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}