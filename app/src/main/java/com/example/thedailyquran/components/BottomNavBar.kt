package com.example.thedailyquran.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Circle
import androidx.compose.material.icons.rounded.CompassCalibration
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LockClock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.sp

@Composable
fun NavBar() {
    var selectedItem by remember { mutableStateOf(0) }
    val itemLabels = listOf("Home", "Qibla", "Prayers", "Tasbeeh")
    val itemIcons = listOf(
        Icons.Rounded.Home, Icons.Rounded.CompassCalibration,
        Icons.Rounded.LockClock, Icons.Rounded.Circle
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        ) {
        itemLabels.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(itemIcons[index], contentDescription = null) },
                label = { Text(item, fontSize = 14.sp) },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    }
}
