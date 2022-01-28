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
import com.codefumes.thedailyquran.navigation.Screen
import com.codefumes.thedailyquran.ui.theme.*


@ExperimentalMaterial3Api
@Composable
fun AsmaUlHusnaPage(modifier: Modifier = Modifier, navController: NavHostController) {
    val list = mutableListOf<Asma>()
    val ArabicAsma: Array<String> = arrayOf(
    "الرَّحْمَنُ", "الرَّحِيمُ", "الْمَلِكُ", "الْقُدُّوسُ","السَّلاَمُ","الْمُؤْمِنُ", "الْمُهَيْمِنُ", "الْعَزِيزُ", "الْجَبَّارُ","الْمُتَكَبِّر","الْخَالِقُ",
        "الْبَارِئُ", "الْمُصَوِّرُ", "الْغَفَّارُ", "الْقَهَّارُ", "الْوَهَّابُ", "الرَّزَّاقُ", "الْفَتَّاحُ", "اَلْعَلِيْمُ", "الْقَابِضُ"
    )
    val AsmaMeaning: Array<String> = arrayOf(
        "The Beneficent","The Merciful", "The King", "The Most Sacred","The Source of Peace","The Infuser of Faith",
        "The Preserver of Safety","All Mighty","The Compeller","The Supreme", "The Creator","The Evolver", "The Fashioner",
        "The Great Forgiver", "The All-Prevailing One", "The Supreme Bestower","The Provider","The Supreme Solver","The All-Knowing",
        "The Withholder"
    )
    for (i in 0 until 10) {
        list.add(Asma(ArabicAsma[i],AsmaMeaning[i]))
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
                                        painterResource(id = R.drawable.asma_ul_husna),
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
            AsmaUlHusnaList(asma = list)
        }
    })
}
@Composable
fun AsmaUlHusnaList(
    asma: List<Asma>
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        asma.forEach {
            Asma(asma = it)
        }
    }
}

@Composable
fun Asma(
    asma: Asma
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
                text = asma.arabicAsma,
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                color = bgDark,
                text = asma.meaning,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

data class Asma(val arabic_name: String, val meaning_: String) {
    val arabicAsma: String = arabic_name;
    val meaning : String = meaning_;
}