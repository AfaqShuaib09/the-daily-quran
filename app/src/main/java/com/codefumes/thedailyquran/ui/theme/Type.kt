package com.codefumes.thedailyquran.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.codefumes.thedailyquran.R

private val light = Font(R.font.outfit_light, FontWeight.W300)
private val regular = Font(R.font.outfit_regular, FontWeight.W400)
private val medium = Font(R.font.outfit_medium, FontWeight.W500)
private val semibold = Font(R.font.outfit_semibold, FontWeight.W600)


private val appFontFamily = FontFamily(fonts = listOf(light, regular, medium, semibold))

val QuranAppTypography = Typography(
    displayLarge = Typography().displayLarge.copy(fontFamily = appFontFamily),
    displayMedium = Typography().displayMedium.copy(fontFamily = appFontFamily),
    displaySmall = Typography().displaySmall.copy(fontFamily = appFontFamily),
    headlineLarge = Typography().headlineLarge.copy(fontFamily = appFontFamily),
    headlineMedium = Typography().headlineMedium.copy(fontFamily = appFontFamily),
    headlineSmall = Typography().headlineSmall.copy(fontFamily = appFontFamily),
    titleLarge = Typography().titleLarge.copy(fontFamily = appFontFamily),
    titleMedium = Typography().titleMedium.copy(fontFamily = appFontFamily),
    titleSmall = Typography().titleSmall.copy(fontFamily = appFontFamily),
    bodyLarge = Typography().bodyLarge.copy(fontFamily = appFontFamily),
    bodyMedium = Typography().bodyMedium.copy(fontFamily = appFontFamily),
    bodySmall = Typography().bodySmall.copy(fontFamily = appFontFamily),
    labelLarge = Typography().labelLarge.copy(fontFamily = appFontFamily),
    labelMedium = Typography().labelMedium.copy(fontFamily = appFontFamily),
    labelSmall = Typography().labelSmall.copy(fontFamily = appFontFamily),
)

val NooreHudaFont = FontFamily(fonts = listOf(Font(R.font.noorehuda)))