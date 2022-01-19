package com.example.thedailyquran.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.thedailyquran.ui.theme.skin1

@Composable
fun TasbeehGoal(title: String, progress: Float, dua: String){
    Column {
        Divider(color= MaterialTheme.colorScheme.primary, thickness = 1.dp)
        Spacer(Modifier.size(10.dp))
        Text(text=title, style= MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.size(20.dp))
        Text(
            text = dua,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(Modifier.size(10.dp))
        LinearProgressIndicator(
            progress = ((progress)),
            modifier = Modifier.align(Alignment.End),
            color = skin1,
            backgroundColor = skin1.copy(alpha = 0.2f)
        )
    }
}