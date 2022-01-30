package com.codefumes.thedailyquran.components

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.codefumes.thedailyquran.navigation.Screen

@ExperimentalMaterial3Api
@Composable
fun NavDrawer(
    drawerState: DrawerState,
    scope: CoroutineScope,
    navController: NavHostController,
    content: @Composable () -> Unit
) {
    val activity = (LocalContext.current as? Activity);
    NavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(Screen.About.route)
                }) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Divider(color = MaterialTheme.colorScheme.primary, thickness = 2.dp)
                    Spacer(modifier = Modifier.padding(5.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            Icons.Outlined.Info,
                            contentDescription = null,
                            modifier = Modifier.padding(end = 5.dp)
                        )
                        Text(
                            text = "About",
                            color = MaterialTheme.colorScheme.onBackground,
                            style = MaterialTheme.typography.headlineSmall,
                        )
                    }
                    Spacer(modifier = Modifier.padding(5.dp))
                    Divider(color = MaterialTheme.colorScheme.primary, thickness = 2.dp)
                }
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    activity?.finish()
                }) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.padding(5.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            Icons.Outlined.ExitToApp,
                            contentDescription = null,
                            modifier = Modifier.padding(end = 5.dp)
                        )
                        Text(
                            text = "Exit",
                            color = MaterialTheme.colorScheme.onBackground,
                            style = MaterialTheme.typography.headlineSmall,
                        )
                    }
                    Spacer(modifier = Modifier.padding(5.dp))
                    Divider(color = MaterialTheme.colorScheme.primary, thickness = 2.dp)
                }
            }
        },
        drawerContainerColor = MaterialTheme.colorScheme.background,
        content = {
            content()
        },
        drawerShape = RoundedCornerShape(0.dp, 0.dp, 0.dp, 0.dp)
    )
}

