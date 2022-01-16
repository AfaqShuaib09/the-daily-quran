package com.example.thedailyquran.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.text.font.FontWeight
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun TopBar(drawerState: DrawerState, scope: CoroutineScope) {
//    var drawerState = rememberDrawerState(DrawerValue.Closed)
//    val scope = rememberCoroutineScope()
//    NavDrawer(drawerState = drawerState, scope = scope, content= content)
    val scrollBehavior = remember { TopAppBarDefaults.pinnedScrollBehavior() }
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "The Daily Quran",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.ExtraBold)
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    when (drawerState.isOpen) {
                        true -> {
                            scope.launch { drawerState.close() }
                        }
                        else -> {
                            scope.launch { drawerState.open() }
                        }
                    }
                },
            ) {
                Icon(Icons.Rounded.Menu, contentDescription = null)
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        scrollBehavior = scrollBehavior,
    )
}

