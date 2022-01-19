package com.example.thedailyquran.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableState
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thedailyquran.layout.MainLayout
import com.example.thedailyquran.ui.theme.*
import com.example.thedailyquran.R
import org.intellij.lang.annotations.JdkConstants
import java.text.SimpleDateFormat
import java.util.*

@ExperimentalMaterial3Api
@Composable
fun PrayerTimePage(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    val sdf = SimpleDateFormat("dd/MMM/yyyy")
    val currentDate = sdf.format(Date())
    val list = mutableListOf<Prayer>()
    val prayerName: Array<String> = arrayOf("Fajar", "Zuhr" , "Asr", "Maghrib", "Esha")
    val prayerTime: Array<String> = arrayOf("5:30 A.M", "1:30 P.M", "3:30 P.M", "5:15 P.M", "6:45 P.M")
    for(i in 0 until 5) {
        list.add(Prayer(prayerName[i], prayerTime[i]))
    }
    MainLayout() {
        Column(
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
                        Spacer(modifier.size(25.dp))
                        Row() {
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
                        Image(
                            painterResource(id = R.drawable.nabawi_mosque),
                            contentDescription = "nabwi_mosque",
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .size(100.dp)
                        )
                        Spacer(modifier.size(12.dp))
                        Row(){
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
            Spacer(modifier.size(25.dp))
               PrayersList(prayers = list)
        }
        }
}

@Composable
fun PrayersList(
    prayers: List<Prayer>
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        prayers.forEach{
            prayer(prayer = it)
        }
    }
}

@Composable
fun prayer(
    prayer : Prayer
){
    Surface(
        color = skin2,
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 4.dp,
        contentColor = white,
        modifier = Modifier.padding(bottom = 10.dp)
    ){

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = prayer.name,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Text(
                text = prayer.time,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}


data class Prayer(val name: String, val time_: String){
    val prayer: String = name;
    val time : String = time_;
}