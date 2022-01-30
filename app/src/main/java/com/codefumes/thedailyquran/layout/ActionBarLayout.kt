package com.codefumes.thedailyquran.layout

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.codefumes.thedailyquran.components.NavBar
import com.codefumes.thedailyquran.components.NavDrawer
import com.codefumes.thedailyquran.components.TopActionBar
import com.codefumes.thedailyquran.components.TopBar
import com.codefumes.thedailyquran.ui.theme.orange1
import com.codefumes.thedailyquran.ui.theme.white

@ExperimentalMaterial3Api
@Composable
fun ActionBarLayout(
    navController: NavHostController,
    content: @Composable () -> Unit,
    actions: @Composable () -> Unit
) {
    var drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopActionBar(drawerState = drawerState, scope = scope, actions = actions)
        },
        bottomBar = { NavBar(navController = navController) }
    ) {
        val context = LocalContext.current;
        NavDrawer(drawerState = drawerState, scope = scope, navController = navController){
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