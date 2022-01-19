package com.example.thedailyquran.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Circle
import androidx.compose.material.icons.rounded.CompassCalibration
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LockClock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.thedailyquran.navigation.Screen

val items = listOf(
    Screen.Home,
    Screen.Qiblah,
    Screen.Prayer,
    Screen.Tasbeeh
)

@Composable
fun NavBar(navController: NavHostController) {

    var selectedItem by remember { mutableStateOf(0) }
    val itemLabels = listOf("Home", "Qibla", "Prayers", "Tasbeeh")
    val itemIcons = listOf(
        Icons.Rounded.Home, Icons.Rounded.CompassCalibration,
        Icons.Rounded.LockClock, Icons.Rounded.Circle
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEachIndexed { index, screen ->
            NavigationBarItem(
                icon = { Icon(itemIcons[index], contentDescription = null) },
                label = { Text(itemLabels[index], fontSize = 14.sp) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.primary,
                ),
            )
        }
    }
}
