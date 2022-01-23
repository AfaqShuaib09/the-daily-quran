package com.codefumes.thedailyquran.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope

@ExperimentalMaterial3Api
@Composable
fun NavDrawer(drawerState: DrawerState, scope: CoroutineScope, content: @Composable () -> Unit) {
    NavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
        },
        drawerContainerColor = MaterialTheme.colorScheme.background,
        content = {
            content()
        },
        drawerShape = RoundedCornerShape(0.dp, 0.dp, 0.dp, 0.dp)
    )
}