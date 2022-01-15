package com.example.thedailyquran.layout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.thedailyquran.components.NavBar
import com.example.thedailyquran.components.TopBar
import com.example.thedailyquran.ui.theme.orange1
import com.example.thedailyquran.ui.theme.white

@ExperimentalMaterial3Api
@Composable
fun MainLayout(
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar= { TopBar() },
        bottomBar = { NavBar() },
    ) {
        Surface(
            modifier = Modifier.padding(horizontal = 17.dp).padding(bottom = 80.dp),
            color = Color.Transparent
        ) {
            content()
        }
    }
}