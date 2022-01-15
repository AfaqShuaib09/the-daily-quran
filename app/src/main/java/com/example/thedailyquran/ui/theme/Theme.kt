package com.example.thedailyquran.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColorScheme(
    primary = skin2,
    onPrimary = pink1,
    secondary = orange1,
    onSecondary = pink2,
    background = bgDark,
    onBackground = white,
    primaryContainer = bgDark
)

private val LightColorPalette = lightColorScheme(
    primary = skin2,
    onPrimary = pink1,
    secondary = orange1,
    onSecondary = pink2,
    background = bgLight,
    onBackground = black,
    primaryContainer = bgLight
)

@Composable
fun TheDailyQuranTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = QuranAppTypography,
        content = content
    )
}