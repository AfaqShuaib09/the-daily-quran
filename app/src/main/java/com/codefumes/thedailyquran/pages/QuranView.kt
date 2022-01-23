package com.codefumes.thedailyquran.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import com.codefumes.thedailyquran.ui.theme.NooreHudaFont
import com.codefumes.thedailyquran.ui.theme.QuranVerseDivider
import com.codefumes.thedailyquran.ui.theme.skin1

@ExperimentalMaterial3Api
@Composable
fun QuranView(modifier: Modifier = Modifier, navController: NavHostController) {
    val scrollState = rememberScrollState()
    val surahRahmanVerseList = listOf<String>("ٱلرَّحۡمَٰنُ","عَلَّمَ ٱلۡقُرۡءَانَ","خَلَقَ ٱلۡإِنسَٰنَ","عَلَّمَهُ ٱلۡبَيَانَ","ٱلشَّمۡسُ وَٱلۡقَمَرُ بِحُسۡبَانٖ","وَٱلنَّجۡمُ وَٱلشَّجَرُ يَسۡجُدَانِ","وَٱلسَّمَآءَ رَفَعَهَا وَوَضَعَ ٱلۡمِيزَانَ","أَلَّا تَطۡغَوۡاْ فِي ٱلۡمِيزَانِ","وَأَقِيمُواْ ٱلۡوَزۡنَ بِٱلۡقِسۡطِ وَلَا تُخۡسِرُواْ ٱلۡمِيزَانَ","وَٱلۡأَرۡضَ وَضَعَهَا لِلۡأَنَامِ","فِيهَا فَٰكِهَةٞ وَٱلنَّخۡلُ ذَاتُ ٱلۡأَكۡمَامِ","وَٱلۡحَبُّ ذُو ٱلۡعَصۡفِ وَٱلرَّيۡحَانُ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","خَلَقَ ٱلۡإِنسَٰنَ مِن صَلۡصَٰلٖ كَٱلۡفَخَّارِ","وَخَلَقَ ٱلۡجَآنَّ مِن مَّارِجٖ مِّن نَّارٖ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","رَبُّ ٱلۡمَشۡرِقَيۡنِ وَرَبُّ ٱلۡمَغۡرِبَيۡنِ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","مَرَجَ ٱلۡبَحۡرَيۡنِ يَلۡتَقِيَانِ","بَيۡنَهُمَا بَرۡزَخٞ لَّا يَبۡغِيَانِ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","يَخۡرُجُ مِنۡهُمَا ٱللُّؤۡلُؤُ وَٱلۡمَرۡجَانُ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","وَلَهُ ٱلۡجَوَارِ ٱلۡمُنشَـَٔاتُ فِي ٱلۡبَحۡرِ كَٱلۡأَعۡلَٰمِ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","كُلُّ مَنۡ عَلَيۡهَا فَانٖ","وَيَبۡقَىٰ وَجۡهُ رَبِّكَ ذُو ٱلۡجَلَٰلِ وَٱلۡإِكۡرَامِ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","يَسۡـَٔلُهُۥ مَن فِي ٱلسَّمَٰوَٰتِ وَٱلۡأَرۡضِۚ كُلَّ يَوۡمٍ هُوَ فِي شَأۡنٖ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","سَنَفۡرُغُ لَكُمۡ أَيُّهَ ٱلثَّقَلَانِ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","يَٰمَعۡشَرَ ٱلۡجِنِّ وَٱلۡإِنسِ إِنِ ٱسۡتَطَعۡتُمۡ أَن تَنفُذُواْ مِنۡ أَقۡطَارِ ٱلسَّمَٰوَٰتِ وَٱلۡأَرۡضِ فَٱنفُذُواْۚ لَا تَنفُذُونَ إِلَّا بِسُلۡطَٰنٖ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","يُرۡسَلُ عَلَيۡكُمَا شُوَاظٞ مِّن نَّارٖ وَنُحَاسٞ فَلَا تَنتَصِرَانِ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","فَإِذَا ٱنشَقَّتِ ٱلسَّمَآءُ فَكَانَتۡ وَرۡدَةٗ كَٱلدِّهَانِ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","فَيَوۡمَئِذٖ لَّا يُسۡـَٔلُ عَن ذَنۢبِهِۦٓ إِنسٞ وَلَا جَآنّٞ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","يُعۡرَفُ ٱلۡمُجۡرِمُونَ بِسِيمَٰهُمۡ فَيُؤۡخَذُ بِٱلنَّوَٰصِي وَٱلۡأَقۡدَامِ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","هَٰذِهِۦ جَهَنَّمُ ٱلَّتِي يُكَذِّبُ بِهَا ٱلۡمُجۡرِمُونَ","يَطُوفُونَ بَيۡنَهَا وَبَيۡنَ حَمِيمٍ ءَانٖ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","وَلِمَنۡ خَافَ مَقَامَ رَبِّهِۦ جَنَّتَانِ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","ذَوَاتَآ أَفۡنَانٖ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","فِيهِمَا عَيۡنَانِ تَجۡرِيَانِ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","فِيهِمَا مِن كُلِّ فَٰكِهَةٖ زَوۡجَانِ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","مُتَّكِـِٔينَ عَلَىٰ فُرُشِۭ بَطَآئِنُهَا مِنۡ إِسۡتَبۡرَقٖۚ وَجَنَى ٱلۡجَنَّتَيۡنِ دَانٖ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","فِيهِنَّ قَٰصِرَٰتُ ٱلطَّرۡفِ لَمۡ يَطۡمِثۡهُنَّ إِنسٞ قَبۡلَهُمۡ وَلَا جَآنّٞ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","كَأَنَّهُنَّ ٱلۡيَاقُوتُ وَٱلۡمَرۡجَانُ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","هَلۡ جَزَآءُ ٱلۡإِحۡسَٰنِ إِلَّا ٱلۡإِحۡسَٰنُ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","وَمِن دُونِهِمَا جَنَّتَانِ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","مُدۡهَآمَّتَانِ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","فِيهِمَا عَيۡنَانِ نَضَّاخَتَانِ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","فِيهِمَا فَٰكِهَةٞ وَنَخۡلٞ وَرُمَّانٞ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","فِيهِنَّ خَيۡرَٰتٌ حِسَانٞ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","حُورٞ مَّقۡصُورَٰتٞ فِي ٱلۡخِيَامِ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","لَمۡ يَطۡمِثۡهُنَّ إِنسٞ قَبۡلَهُمۡ وَلَا جَآنّٞ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","مُتَّكِـِٔينَ عَلَىٰ رَفۡرَفٍ خُضۡرٖ وَعَبۡقَرِيٍّ حِسَانٖ","فَبِأَيِّ ءَالَآءِ رَبِّكُمَا تُكَذِّبَانِ","تَبَٰرَكَ ٱسۡمُ رَبِّكَ ذِي ٱلۡجَلَٰلِ وَٱلۡإِكۡرَامِ")
    val (openDialog, setOpenDialog) = remember { mutableStateOf(false) }
    val (surahInfo, setSurahInfo) = remember {
        mutableStateOf("[پارہ ۲۷] اٹھتر چھوٹی چھوٹی آیتوں اور تین رکوع پر مشتمل مدنی سورت ہے۔ اس میں قانون سازی کی بجائے توحید باری تعالیٰ پر کائناتی شواہد قائم کئے گئے ہیں اور قیامت کے مناظر، جہنم کی ہولناکی اور خاص طور پر جنت اور اس کے خوشمنا مناظر کو نہایت خوبصورتی اور تفصیل کے ساتھ بیان کیا گیا ہے۔ ایک حدیث شریف میں اس سورت کو عروس القرآن یعنی ''قرآن کریم کی دلہن\" قرار دیا گیا ہے۔ اس میں بالکل منفرد انداز میں ایک ہی جملہ ''فبأی الٓاء ربکما تکذبان'' تم اپنے رب کی کون کون سے نعمتوں کو جھٹلاؤ گے، کو اکتیس مرتبہ دہرایا گیا ہے۔ حدیث میں آتا ہے کہ جنات کو جب حضور ﷺ نے سورۃ الرحمٰن سنائی تو وہ ہر مرتبہ یہی کہتےرہے ''لا بشیٔ من نعمک ربنا نکذب فلک الحمد'' ہم آپ کی کسی بھی نعمت کو نہیں جھٹلاتے، تمام تعریفیں آپ ہی کے لئے ہیں۔ شروع سورت میں بتایا ہے کہ رحمت الہٰیہ کے مظاہر میں ایک بڑا مظہر قرآن کریم کی تعلیم اور انسان کو اس کے پڑھنے کا سلیقہ سکھانا اور اسے قوت بیان کا عطا کرنا ہے۔ سورج اور چاند حساب کے ایک نہایت ہی دقیق نظام کے تحت چل رہے ہیں، پودے اور درخت بھی اللہ کے نظام کے پابند اور اس کے سامنے سجدہ ریز ہیں۔ اسی نے آسمان کو بلند کیا اور عدل و انصاف کا مظہر ''ترازو'' پیدا کیا لہذا ناپ تول میں کسی کمی کا مظاہرہ نہیں کرنا چاہئے۔ زمین کو اس انداز پر پیدا کیا کہ تمام مخلوقات اس پر بآسانی زندگی بسر کرسکیں۔ اس میں پھول، خوشہ دار کھجور، غلے اور چارہ اور خوشبودار پھول پیدا کئے۔ ان نعمتوں میں غور کر کے بتاؤ آخر تم اپنے رب کی کون کون سی نعمتوں کا انکار کرو گے۔ ایسی مٹی جو خشک ہو کر بجنے لگ جاتی ہے ہماری قدرت کا کمال دیکھو کہ ہم نے اس سے نرم و نازک جسم والا انسان پیدا کر دیا اور جنات کو بھڑکنے والی آگے سے پیدا کیا۔ کھارے اور میٹھے پانی کی لہروں کو آپس میں مل کر ایک دوسرے کا ذائقہ اور تاثیر بدلنے سے اس طرح روکا جیسے ان  کے درمیان کوئی حد فاصل قائم ہو ۔ ان سے موتی اورمرجان کو خوشنما پتھر بھی حاصل ہوتا ہے اور پہاڑوں جیسی ضخامت کے بحری جہاز بھی ان سمندروں کے اندر تیرتے اور نقل و حمل کے لئے سفر کرتے ہیں۔ کائنات کی ہر چیز کو فنا ہے مگر رب ذوالجلال کے لئے دائمی بقاء ہے۔ اس طرح انعامت خداوندی کے تذکرہ کے بعد قیامت کے ہولناک مناظر اور جہنم کی دہشت ناک سزاؤں کا تذکرہ کیا اور جنت کے روح پرور مناظر کا بیان شروع کر دیا جس میں باغات اور چشمے، انواع و اقسام کے پھل، ریشم و کمخواب کے لباس، یاقوت و مرجان کی طرح حسن و جمال اور خوبصورتی کی پیکر جنتی حوریں جو اپنے شوہر کے علاوہ کسی کی طرف نگاہ اٹھا کر بھی نہ دیکھتی ہوں گی اور آخر میں رب ذوالجلال والا کرام کے نام کی برکتوں کے تذکرہ پر سورت کو ختم کیا گیا۔")
    }

    MainLayout (navController = navController) {
        Column (
            modifier = Modifier.verticalScroll(scrollState)
        ) {
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
                                    text = "Al Rahman",
                                    style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.ExtraBold),
                                )
                                Spacer(modifier.size(8.dp))
                                Text(
                                    text = "The Merciful",
                                    style = MaterialTheme.typography.headlineSmall,
                                )
                                Spacer(modifier.size(34.dp))
                                Text(
                                    text = "78 Verses",
                                    style = MaterialTheme.typography.bodyLarge,
                                )
                                Spacer(modifier.size(8.dp))
                                Text(
                                    text = "Madni Surah",
                                    style = MaterialTheme.typography.bodyLarge,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.End
                            ) {
                                Text(
                                    text = "الرَّحۡمٰنِ",
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
                    Text(text = "Learn About This Surah ", style = MaterialTheme.typography.headlineSmall)
                    Icon(Icons.Rounded.ArrowForwardIos , contentDescription = null, tint = white, modifier = Modifier.size(22.dp))
                }
            }
            Spacer(modifier.size(35.dp))
            QuranVerseDivider()
            surahRahmanVerseList.forEachIndexed{
                index, item ->
                    QuranVerse(ayat = item, translation = "Translation Text Here Translation Text Here Translation Text Here Translation Text Here ", verseNo = index + 1)
            }
        }

//        verse info dialog
        if(openDialog) {
            var dialogScrollState = rememberScrollState()
            AlertDialog(
                onDismissRequest = { /*TODO*/ },
                title = { Text(text = "سورۃ کا پس منظر", textAlign = TextAlign.Center) },
                text = { Column(
                    modifier = Modifier.verticalScroll(dialogScrollState)
                ) {
                    Text(text = surahInfo, fontSize = 4.em)
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

