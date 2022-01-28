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
    val SurahName: Array<String> = arrayOf(
        "Al-Fatihah",
        "Al-Baqara ",
        "Al-i'Imran ",
        "An-Nisaa ",
        "Al-Maidah ",
        "Al-An'am ",
        "Al-A'raf ",
        "Al-Anfal ",
        "At-Tauba ",
        "Yunus ",
        "Hud ",
        "Yusuf ",
        "Ar-Ra'd ",
        "Ibrahim ",
        "Al-Hijr ",
        "An-Nahl ",
        "Al-Israa ",
        "Al-Kahf ",
        "Maryam ",
        "Ta-ha ",
        "Al-Anbiyaa ",
        "Al-Hajj ",
        "Al-Muminun ",
        "An-Nur ",
        "Al-Furqan ",
        "Ash-Shu'araa ",
        "An-Naml ",
        "Al-Qasas ",
        "Al-Ankabut ",
        "Ar-Rum ",
        "Luqman ",
        "As-Sajda ",
        "Al-Ahzab ",
        "Saba ",
        "Fatir ",
        "Ya-Sin ",
        "As-Saffat ",
        "Sad ",
        "Az-Zumar ",
        "Al-Mu'min ",
        "Ha-Mim ",
        "Ash-Shura ",
        "Az-Zukhruf ",
        "Ad-Dukhan ",
        "Al-Jathiya ",
        "Al-Ahqaf ",
        "Muhammad ",
        "Al-Fat-h ",
        "Al-Hujurat ",
        "Qaf ",
        "Az-Zariyat ",
        "At-Tur ",
        "An-Najm ",
        "Al-Qamar ",
        "Ar-Rahman ",
        "Al-Waqi'a ",
        "Al-Hadid ",
        "Al-Mujadila ",
        "Al-Hashr ",
        "Al-Mumtahana ",
        "As-Saff ",
        "Al-Jumu'a ",
        "Al-Munafiqun ",
        "At-Tagabun ",
        "At-Talaq ",
        "At-Tahrim ",
        "Al-Mulk ",
        "Al-Qalam ",
        "Al-Haqqa ",
        "Al-Ma'arij ",
        "Nuh ",
        "Al-Jinn ",
        "Al-Muzzammil ",
        "Al-Muddathth ",
        "Al-Qiyamat ",
        "Ad-Dahr ",
        "Al-Mursalat ",
        "An-Nabaa ",
        "An-Nazi'at ",
        "Abasa ",
        "At-Takwir ",
        "Al-Infitar ",
        "Al-Mutaffife ",
        "Al-Inshiqaq ",
        "Al-Buruj ",
        "At-Tariq ",
        "Al-A'la ",
        "Al-Gashiya ",
        "Al-Fajr ",
        "Al-Balad ",
        "Ash-Shams ",
        "Al-Lail ",
        "Adh-Dhuha ",
        "Al-Sharh ",
        "At-Tin ",
        "Al-Alaq ",
        "Al-Qadr ",
        "Al-Baiyina ",
        "Al-Zalzalah ",
        "Al-Adiyat ",
        "Al-Qari'a ",
        "At-Takathur ",
        "Al-Asr ",
        "Al-Humaza ",
        "Al-Fil ",
        "Quraish ",
        "Al-Ma'un ",
        "Al-Kauthar ",
        "Al-Kafirun ",
        "An-Nasr ",
        "Al-Lahab ",
        "Al-Ikhlas ",
        "Al-Falaq ",
        "Al-Nas "
    )
    val SurahArbicName: Array<String> = arrayOf(
        "الفاتحۃ",
        "البقرۃ",
        "آل عمران",
        "النسآء",
        "المآئدۃ",
        "الانعام",
        "الاعراف",
        "الانفال",
        "التوبۃ",
        "یونس",
        "ھود",
        "یوسف",
        "الرعد",
        "ابراھیم",
        "الحجر",
        "النحل",
        "الاسراء",
        "الکہف",
        "مریم",
        "طٰہٰ",
        "الانبیآء",
        "الحج",
        "المؤمنون",
        "النور",
        "الفرقان",
        "الشعراء",
        "النمل",
        "القصص",
        "العنکبوت",
        "الروم",
        "لقمٰن",
        "السجدۃ",
        "الاحزاب",
        "سبا",
        "فاطر",
        "یٰسٓ",
        "الصّٰفّٰت",
        "صٓ",
        "الزمر",
        "الغافر",
        "فصلت",
        "الشُّورٰی",
        "الزُّخرُف",
        "الدُّخَان",
        "الجاثیہ",
        "الاحقاف",
        "محمد",
        "الفتح",
        "الحجرات",
        "قٓ",
        "الذّٰریٰت",
        "الطّور",
        "النجم",
        "القمر",
        "الرحمٰن",
        "الواقعۃ",
        " الحدید",
        "المجادلۃ",
        "الحشر",
        " الممتحنۃ",
        "الصّف",
        "الجُمعۃ",
        "المُنٰفِقُون",
        " التّغابن",
        "الطّلاق",
        "التحریم",
        "الملک",
        "القلم",
        " الحاقہ",
        "المعارج",
        "نُوح",
        "الجن",
        "المزّمّل",
        "المدّثّر",
        "القیٰمۃ",
        "الانسان",
        "المرسلٰت",
        "النَّبَاِ",
        "النّٰزِعٰتِ",
        "عَبَسَ",
        " التَّکوِیر",
        " الاِنفِطَار",
        "المُطَفِّفِین",
        "الاِنشِقَاق",
        "البُرُوج",
        "الطَّارق",
        "الاَعلیٰ",
        "الغَاشِیَۃ",
        "الفجر",
        "البلد",
        " الشَّمس",
        "الَّیل",
        "الضُّحٰی",
        "الم نشرح",
        "التّین",
        "العَلَق",
        " القدر",
        "البیّنۃ",
        "الزّلزال",
        "العٰدیٰت",
        " القارعۃ",
        "التّکاثُر",
        " العصر",
        "الھُمَزَۃ",
        "الفِیل",
        "قُرَیش",
        "المَاعُون",
        "الکوثر",
        "الکٰفرون",
        "النَّصَر",
        "اللَّھب",
        "الاخلاص",
        "الفَلَق",
        " النَّاس"
    )
    for (i in 0 until 114) {
        list.add(Surah(SurahName[i], SurahArbicName[i]))
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
                style = MaterialTheme.typography.labelLarge,
                //modifier = Modifier.padding(horizontal = 10.dp)
            )
            Text(
                color = black,
                text = surah.time,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}


data class Surah(val name: String, val time_: String) {
    val prayer: String = name;
    val time: String = time_;
}
