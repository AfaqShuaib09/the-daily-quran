package com.example.thedailyquran.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.thedailyquran.ui.theme.*

@Composable
fun QuranVerse(modifier: Modifier = Modifier, ayat: String, translation: String, verseNo: Int) {
    Row(
    ) {
        Column {
            Spacer(modifier.size(25.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(text = "بَلٰی ٭  مَنۡ اَسۡلَمَ وَجۡہَہٗ  لِلّٰہِ وَ ہُوَ  مُحۡسِنٌ فَلَہٗۤ اَجۡرُہٗ عِنۡدَ رَبِّہٖ ۪ وَ لَا خَوۡفٌ عَلَیۡہِمۡ  وَ لَا ہُمۡ  یَحۡزَنُوۡنَ ﴿۱۱۲﴾", fontSize = 11.em, fontFamily = NooreHudaFont, lineHeight = 1.5.em, textAlign = TextAlign.Start)
            }
            Spacer(modifier.size(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(text = translation, style=MaterialTheme.typography.headlineSmall)
            }
            Spacer(modifier.size(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Row() {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Rounded.Bookmark , contentDescription = null, tint = skin1, modifier = Modifier.size(35.dp))
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Rounded.PlayArrow , contentDescription = null, tint = skin1, modifier = Modifier.size(50.dp))
                        }
                    }
                }
                Column() {
                    Surface(
                        shape = CircleShape,
                        modifier = Modifier.border(2.dp, skin1, CircleShape).size(40.dp).padding(8.dp).background(Color.Transparent)
                    ) {
                        Text(text = verseNo.toString(), color = skin1, textAlign = TextAlign.Center, style=MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold))
                    }
                }
            }
            Spacer(modifier.size(25.dp))
            QuranVerseDivider()
        }
    }
}