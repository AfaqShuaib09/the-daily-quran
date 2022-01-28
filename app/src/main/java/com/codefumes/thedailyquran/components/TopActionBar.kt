package com.codefumes.thedailyquran.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontWeight
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun TopActionBar(drawerState: DrawerState, scope: CoroutineScope, actions: @Composable () -> Unit) {
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
        actions = {
            actions()
        }
    )
}

