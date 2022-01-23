package com.codefumes.thedailyquran.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.codefumes.thedailyquran.models.TasbeehGoal
import com.codefumes.thedailyquran.ui.theme.skin1

@Composable
fun TasbeehGoal(tasbeehGoal: TasbeehGoal){
    val context = LocalContext.current;
    val interactionSource = remember { MutableInteractionSource()};
    Column(
        modifier = Modifier.clickable{

        }
    ) {

            Divider(color = MaterialTheme.colorScheme.primary, thickness = 1.dp)
            Spacer(Modifier.size(10.dp))
            Text(text = tasbeehGoal.title, style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.size(20.dp))
            Text(
                text = tasbeehGoal.dua,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.align(Alignment.End)
            )
            Spacer(Modifier.size(10.dp))
            LinearProgressIndicator(
                progress = ((tasbeehGoal.getCurrProgress())),
                modifier = Modifier.align(Alignment.End),
                color = skin1,
                backgroundColor = skin1.copy(alpha = 0.2f)
            )

    }
}