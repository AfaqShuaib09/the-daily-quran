package com.codefumes.thedailyquran.layout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.codefumes.thedailyquran.components.NavBar
import com.codefumes.thedailyquran.components.NavDrawer
import com.codefumes.thedailyquran.components.TopBar
import com.codefumes.thedailyquran.components.TopEmptyBar
import com.codefumes.thedailyquran.ui.theme.orange1
import com.codefumes.thedailyquran.ui.theme.white

@ExperimentalMaterial3Api
@Composable
fun EmptyLayout(
    navController: NavHostController,
    content: @Composable () -> Unit
) {
    var drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopEmptyBar(navController = navController)
        }
    ) {
        NavDrawer(drawerState = drawerState, scope = scope, navController=navController) {
            Surface(
                modifier = Modifier
                    .padding(horizontal = 17.dp)
                    .padding(bottom = 80.dp),
                color = Color.Transparent
            ) {
                content()
            }
        }
    }
}