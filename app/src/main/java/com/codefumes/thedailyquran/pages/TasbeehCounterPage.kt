package com.codefumes.thedailyquran.pages

import android.content.ContentValues
import android.content.Context
import android.provider.BaseColumns
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavHostController
import com.codefumes.thedailyquran.ui.theme.*
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.runtime.MutableState
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.codefumes.thedailyquran.DBHelpers.TasbeehGoalDB
import com.codefumes.thedailyquran.R
import com.codefumes.thedailyquran.layout.ActionBarLayout
import com.codefumes.thedailyquran.models.TasbeehGoal
import com.codefumes.thedailyquran.schemas.Contracts


@Composable
fun DropDown(icon: MutableState<ImageVector>, navController: NavHostController) {
    val openDialog = remember { mutableStateOf(false) }
    val context = LocalContext.current
    deleteDialog(openDialog = openDialog, navController)
    var showMenu = remember { mutableStateOf(false) }
    var tint = remember { mutableStateOf(Color.Black) }
    IconButton(onClick = {
        when (icon.value) {
            Icons.Outlined.FavoriteBorder -> {
                icon.value = Icons.Filled.Favorite;
                tint.value = Color.Red;
                Toast.makeText(
                    context,
                    "Goal set as active",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else -> {
                icon.value = Icons.Outlined.FavoriteBorder;
                tint.value = Color.Black;
                Toast.makeText(
                    context,
                    "Goal set as inactive",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }) {
        Icon(icon.value, contentDescription = "Set As Active", tint = tint.value)
    }
    IconButton(onClick = { showMenu.value = !(showMenu.value) }) {
        Icon(Icons.Default.MoreVert, contentDescription = "Menu")
    }
    DropdownMenu(
        expanded = showMenu.value,
        onDismissRequest = { showMenu.value = false },
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    ) {
        DropdownMenuItem(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Replay, "Reset")
            Text("Reset", Modifier.padding(start = 10.dp))
        }
        DropdownMenuItem(onClick = {
            if (!openDialog.value) {
                openDialog.value = true;
            }
        }) {
            Icon(Icons.Filled.Delete, "Delete this goal")
            Text("Delete", Modifier.padding(start = 10.dp))
        }
    }
}

@Composable
fun deleteDialog(openDialog: MutableState<Boolean>, navController: NavHostController) {
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false;
            },
            icon = {
                Icon(Icons.Filled.Delete, "Localized description")
            },
            title = {
                Text(text = "Delete Goal")
            },
            text = {
                Text(text = "Are you sure you want to delete this goal?")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false;
                        navController.popBackStack();
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Dismiss")
                }
            }
        )
    }
}

@ExperimentalMaterial3Api
@Composable
fun TasbeehCounterPage(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    goalID: Int?
) {
    val context = LocalContext.current
    val goal = getGoalById(context = context, goalID)
    val currProg = remember { mutableStateOf(goal.progress) }
    val degreeRotate = remember { mutableStateOf(0f) }
    val progIndicator = remember { mutableStateOf(goal.getCurrProgress()) }
    val favIcon = remember { mutableStateOf(Icons.Outlined.FavoriteBorder) }

    BackHandler() {
        Toast.makeText(context, "YES", Toast.LENGTH_LONG).show();
        navController.popBackStack()
    }

    ActionBarLayout(navController = navController, content = {
        Column(
        ) {
            Surface(
                color = orange1,
                shape = RoundedCornerShape(15.dp),
                shadowElevation = 4.dp,
                contentColor = white,
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    skin1,
                                    skin3
                                )
                            )
                        )
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        color = Color.Transparent
                    ) {
                        Column() {
                            Column(
                            ) {
                                Text(
                                    text = goal.title,
                                    style = MaterialTheme.typography.headlineLarge
                                )
                            }
                            Spacer(modifier.size(20.dp))
                            Column() {
                                Text(
                                    text = "Dua For This Goal:",
                                    style = MaterialTheme.typography.headlineMedium
                                )
                            }
                            Spacer(modifier.size(20.dp))
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = goal.dua,
                                fontSize = 8.em,
                                fontFamily = NooreHudaFont,
                                lineHeight = 1.5.em,
                                textAlign = TextAlign.End
                            )
                            Spacer(modifier.size(20.dp))
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "${(currProg.value).toInt()}/${goal.goal}",
                                    style = MaterialTheme.typography.headlineSmall
                                )
                                LinearProgressIndicator(
                                    progress = progIndicator.value,
                                    color = Color.White,
                                    backgroundColor = Color.Transparent.copy(alpha = 0.1f)
                                )
                            }
                        }
                    }
                }
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box() {
                    Image(
                        painterResource(id = R.drawable.tasbih),
                        contentDescription = "tasbih",
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .align(Alignment.Center)
                            .rotate(degreeRotate.value)
                            .size(200.dp)
                    )
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        ElevatedButton(
                            onClick = {
                                if (currProg.value < goal.goal) {
                                    currProg.value = currProg.value + 1;
                                    degreeRotate.value = degreeRotate.value + (360f / goal.goal);
                                    goal.progress++;
                                    progIndicator.value = goal.getCurrProgress();
                                } else {
                                    Toast.makeText(
                                        context,
                                        "Goal Already Completed",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            },
                            colors = ButtonDefaults.elevatedButtonColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                contentColor = MaterialTheme.colorScheme.onPrimary
                            ),
                            modifier = Modifier.padding(bottom = 35.dp, end = 0.dp)
                        ) {
                            Icon(Icons.Rounded.Add, contentDescription = "Increment")
                        }
                    }
                }
            }
        }
    }, actions = { DropDown(favIcon, navController) })
}

fun getGoalById(context: Context, goalID: Int?): TasbeehGoal {
    val dbhelper = TasbeehGoalDB(context = context);
    val db = dbhelper.readableDatabase;
    val selection = "${BaseColumns._ID} = ?"
    val selectionArgs = arrayOf("$goalID")
    val sortOrder = "${Contracts.TasbeehGoalEntry.COLUMN_NAME_ACTIVE} DESC"
    val cursor = db.query(
        Contracts.TasbeehGoalEntry.TABLE_NAME,   // The table to query
        null,             // The array of columns to return (pass null to get all)
        selection,              // The columns for the WHERE clause
        selectionArgs,          // The values for the WHERE clause
        null,                   // don't group the rows
        null,                   // don't filter by row groups
        sortOrder               // The sort order
    );
    with(cursor) {
        if (moveToNext()) {
            val itemId = getInt(getColumnIndexOrThrow(BaseColumns._ID))
            val itemTitle =
                getString(getColumnIndexOrThrow(Contracts.TasbeehGoalEntry.COLUMN_NAME_TITLE))
            val itemDua =
                getString(getColumnIndexOrThrow(Contracts.TasbeehGoalEntry.COLUMN_NAME_DUA))
            val itemGoal =
                getInt(getColumnIndexOrThrow(Contracts.TasbeehGoalEntry.COLUMN_NAME_GOAL))
            val itemProgress =
                getInt(getColumnIndexOrThrow(Contracts.TasbeehGoalEntry.COLUMN_NAME_PROGRESS))
            val itemActive =
                getInt(getColumnIndexOrThrow(Contracts.TasbeehGoalEntry.COLUMN_NAME_ACTIVE))
            val goal: TasbeehGoal =
                (TasbeehGoal(itemId, itemTitle, itemDua, itemGoal, itemProgress, itemActive))
            cursor.close()
            return goal;
        }
    }
    cursor.close()
    return TasbeehGoal(0, "", "", 0, 0, 0);
}