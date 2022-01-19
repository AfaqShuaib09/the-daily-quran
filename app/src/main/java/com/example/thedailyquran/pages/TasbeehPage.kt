package com.example.thedailyquran.pages

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.thedailyquran.ui.theme.*
import com.example.thedailyquran.layout.FABLayout
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavHostController
import com.example.thedailyquran.components.TasbeehGoal
import com.example.thedailyquran.models.TasbeehGoal

@ExperimentalMaterial3Api
@Composable
fun TasbeehPage(modifier: Modifier = Modifier, navController: NavHostController) {
    val scrollState = rememberScrollState()
    val (currentGoalState, setCurrentGoalState) = remember { mutableStateOf(0) }

    val openDialog = remember { mutableStateOf(false) }

    var goals = remember {
        mutableStateListOf(
            TasbeehGoal("Dua 1", "سبحان الله", 33, 10),
            TasbeehGoal("Dua 2", "الحمد لله", 50, 25),
            TasbeehGoal("Dua 3", "الله أكبر", 90, 10),
            TasbeehGoal("Dua 4", "لَا إِلَٰهَ إِلَّا ٱللَّٰه", 10, 10),
            TasbeehGoal("Dua 5", "رَبَّنَا لاَ تَجْعَلْنَا مَعَ الْقَوْمِ الظَّالِمِين", 20, 6),
            TasbeehGoal(
                "Dua 6",
                "رَبَّنَا أَفْرِغْ عَلَيْنَا صَبْرًا وَتَوَفَّنَا مُسْلِمِين",
                27, 9
            )
        )
    }

    CreateGoalDialog(openDialog = openDialog, goals)

    FABLayout(fab = {
        ExtendedFloatingActionButton(
            onClick = { openDialog.value = true; },
            icon = { Icon(Icons.Filled.Add, "Localized description") },
            text = { Text(text = "Create Goal") },
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.Black
        )
    }, navController = navController, content = {
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
                                    text = "Tasbeeh Goals",
                                    style = MaterialTheme.typography.headlineLarge
                                )
                            }
                            Spacer(modifier.size(20.dp))
                            Column() {
                                Text(
                                    text = "Your Current Goal:",
                                    style = MaterialTheme.typography.headlineSmall
                                )
                            }
                            Spacer(modifier.size(20.dp))
                            Text(
                                text = goals[currentGoalState].dua,
                                style = MaterialTheme.typography.headlineSmall,
                                modifier = Modifier.align(Alignment.End)
                            )
                            Spacer(modifier.size(20.dp))
                            LinearProgressIndicator(
                                progress = goals[currentGoalState].getCurrProgress(),
                                modifier = Modifier.align(Alignment.End),
                                color = Color.White,
                                backgroundColor = Color.Transparent.copy(alpha = 0.1f)
                            )
                        }
                    }
                }
            }
            Spacer(modifier.size(20.dp))
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(goals.size) { index ->
                    TasbeehGoal(
                        title = goals[index].title,
                        dua = goals[index].dua,
                        progress = goals[index].getCurrProgress()
                    )
                }
                item() {
                    Spacer(modifier.size(80.dp))
                }
            }
        }
    })
}

@Composable
fun CreateGoalDialog(openDialog: MutableState<Boolean>, goalList: SnapshotStateList<TasbeehGoal>) {
    val (newGoalTitle, setNewGoalTitle) = remember { mutableStateOf("") }
    val (newGoalDua, setNewGoalDua) = remember { mutableStateOf("") }
    val (newGoalProgress, setNewGoalProgress) = remember { mutableStateOf("") }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            icon = {
                Icon(Icons.Filled.Add, "Localized description")
            },
            title = {
                Text(text = "Create New Goal")
            },
            text = {
                Column() {
                    Spacer(modifier = Modifier.size(10.dp))
                    OutlinedTextField(
                        value = newGoalTitle,
                        onValueChange = { setNewGoalTitle(it) },
                        label = { Text("Title") },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = skin1,
                            cursorColor = skin1,
                            textColor = MaterialTheme.colorScheme.onBackground
                        )
                    )
                    Spacer(modifier = Modifier.size(20.dp))
                    OutlinedTextField(
                        value = newGoalDua,
                        onValueChange = { setNewGoalDua(it) },
                        label = { Text("Dua") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = skin1,
                            cursorColor = skin1,
                            textColor = MaterialTheme.colorScheme.onBackground
                        )
                    )
                    Spacer(modifier = Modifier.size(20.dp))
                    OutlinedTextField(
                        value = newGoalProgress,
                        onValueChange = { setNewGoalProgress(it) },
                        label = { Text("Goal") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = skin1,
                            cursorColor = skin1,
                            textColor = MaterialTheme.colorScheme.onBackground
                        )
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        goalList.add(
                            TasbeehGoal(
                                title = newGoalTitle,
                                dua = newGoalDua,
                                goal = newGoalProgress.toInt()
                            )
                        )
                        setNewGoalTitle("")
                        setNewGoalDua("")
                        setNewGoalProgress("")
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        setNewGoalTitle("")
                        setNewGoalDua("")
                        setNewGoalProgress("")
                    }
                ) {
                    Text("Dismiss")
                }
            }
        )
    }
}

