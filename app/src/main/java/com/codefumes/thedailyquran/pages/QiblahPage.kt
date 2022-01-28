package com.codefumes.thedailyquran.pages

import android.content.Context.SENSOR_SERVICE
import android.hardware.Sensor
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.codefumes.thedailyquran.R
import com.codefumes.thedailyquran.layout.MainLayout
import com.codefumes.thedailyquran.ui.theme.skin1
import com.codefumes.thedailyquran.ui.theme.skin2
import com.codefumes.thedailyquran.ui.theme.skin3
import com.codefumes.thedailyquran.ui.theme.white


@ExperimentalMaterial3Api
@Composable
fun QiblahPage(modifier: Modifier = Modifier, navController: NavHostController) {
    var sensorManager: SensorManager = LocalContext.current.getSystemService(SENSOR_SERVICE) as SensorManager;
    var sensor: Sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);

    var currentDegrees: Float
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
                                        text = "Asma Ul Husna",
                                        style = MaterialTheme.typography.headlineLarge
                                    )
                                    Spacer(modifier.size(10.dp))
                                    Text(
                                        text = "اَلاسْمَاءُ الْحُسناى ",
                                        style = MaterialTheme.typography.labelLarge
                                    )
                                    Spacer(modifier.size(7.dp))
                                    Text(
                                        text = "99 Names of Allah",
                                        style = MaterialTheme.typography.labelMedium
                                    )

                                }
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Image(
                                        painterResource(id = R.drawable.kaabah_vector),
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
            Spacer(modifier.size(35.dp))
            Surface(
                color = skin2,
                shape = RoundedCornerShape(15.dp),
                shadowElevation = 4.dp,
                contentColor = white,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
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
                ){
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painterResource(id = R.drawable.qibla_compass),
                            contentDescription = "quran_icon",
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(10.dp)
                                .size(300.dp)
                        )
                    }
                }
            }
        }
    })
}