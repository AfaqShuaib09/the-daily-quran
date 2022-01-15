package com.example.thedailyquran

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.NavigateNext
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.thedailyquran.components.NavBar
import com.example.thedailyquran.components.TopBar
import com.example.thedailyquran.layout.MainLayout
import com.example.thedailyquran.ui.theme.TheDailyQuranTheme
import com.example.thedailyquran.ui.theme.*
import java.lang.reflect.Type
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheDailyQuranTheme {
                MainView()
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TheDailyQuranTheme {
        MainView()
    }
}


// main view here
@ExperimentalMaterial3Api
@Composable
fun MainView(modifier: Modifier = Modifier) {
    var goalDone: Boolean = true
    val scrollState = rememberScrollState()

    MainLayout() {
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            Spacer(modifier.size(20.dp))
            Text(
                text = "السلام عليكم ورحمة الله وبركاته",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.align(Alignment.End)
            )
            Spacer(modifier.size(20.dp))
            Text(
                text = "Maulana Haq Nawaz",
                style = MaterialTheme.typography.headlineLarge,
                color = orange1
            )
            Spacer(modifier.size(20.dp))
            Surface(
                color = orange1,
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
                    Text(
                        text = "Overall ُُProgress",
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
            Spacer(modifier.size(20.dp))
            Row() {
                Column(
                    modifier = Modifier.fillMaxWidth(0.75f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Surface(
                        color = skin1,
                        shape = RoundedCornerShape(15.dp),
                        shadowElevation = 4.dp,
                        contentColor = white,
                        modifier = Modifier.clickable ( onClick = {})
                    ) {
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(15.dp),
                            color = Color.Transparent
                        ) {
                            Column() {
                                Text(
                                    text = "Today's Goal",
                                    style = MaterialTheme.typography.headlineMedium
                                )
                                Spacer(modifier = Modifier.size(25.dp))
                                Row() {
                                    Text(
                                        text = "Surah ",
                                        style = MaterialTheme.typography.titleLarge
                                    )
                                    Text(
                                        text = "Al Rahman",
                                        style = MaterialTheme.typography.titleLarge,
                                    )
                                }
                                Spacer(modifier = Modifier.size(7.dp))
                                Row() {
                                    Text(
                                        text = "Verse ",
                                        style = MaterialTheme.typography.titleLarge
                                    )
                                    Text(
                                        text = "1 to 32",
                                        style = MaterialTheme.typography.titleLarge,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Spacer(modifier = Modifier.size(7.dp))
                                Row(
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Icon(
                                        Icons.Rounded.NavigateNext,
                                        contentDescription = null,
                                        Modifier.size(35.dp)
                                    )
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.size(10.dp))
                Column(
                    modifier = Modifier.padding(top = 45.dp)
                ) {
                    Surface(
                        color = if (goalDone) green1 else pink1,
                        shape = CircleShape,
                        shadowElevation = 4.dp,
                        contentColor = white,
                        modifier = Modifier.clickable(onClick = {
                            goalDone = if (goalDone) false else true
                        })
                    ) {
                        Surface(
                            modifier = Modifier
                                .padding(8.dp),
                            color = Color.Transparent
                        ) {
                            Surface(
                                color = Color(255,255,255, 0x33),
                                shape = CircleShape,
                                contentColor = white,

                            ) {
                                Surface(
                                    modifier = Modifier
                                        .padding(10.dp),
                                    color = Color.Transparent
                                ) {
                                    if (goalDone) {
                                        Icon(
                                            Icons.Rounded.Done,
                                            contentDescription = null,
                                            Modifier.size(40.dp)
                                        )
                                    } else {
                                        Icon(
                                            Icons.Rounded.Close,
                                            contentDescription = null,
                                            Modifier.size(40.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Spacer(modifier.size(20.dp))
            Row() {
                Column(
                    modifier = Modifier.fillMaxWidth(0.33f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Surface(
                        color = green2,
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
                            Column() {
                                Text(
                                    text = "Holy Quran",
                                    style = MaterialTheme.typography.titleLarge,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                                Image(
                                    painterResource(id = R.drawable.quran),
                                    contentDescription = "Quran",
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.size(10.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Surface(
                        color = pink2,
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
                            Column() {
                                Text(
                                    text = "Miracles from",
                                    style = MaterialTheme.typography.titleLarge,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                                Spacer(modifier = Modifier.size(25.dp))
                                Row (
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    verticalAlignment = Alignment.CenterVertically
                                )
                                {
                                    Text(
                                        text = "Quran",
                                        style = MaterialTheme.typography.headlineLarge,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.padding(bottom = 10.dp)
                                    )
                                    Spacer(modifier = Modifier.size(14.dp))
                                    Image(
                                        painterResource(id = R.drawable.quran__1_),
                                        contentDescription = "Quran",
                                        modifier = Modifier
                                            .size(40.dp)
                                            .rotate(degrees = 10f)
                                    )
                                }
                            }
                        }
                    }
                }
            }
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
                                text = "Supplications",
                                style = MaterialTheme.typography.headlineSmall
                            )
                            Spacer(modifier.size(12.dp))
                            Text(
                                text = "مسنون دعائیں",
                                style = MaterialTheme.typography.headlineSmall
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painterResource(id = R.drawable.supplication_vector),
                                contentDescription = "Quran",
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