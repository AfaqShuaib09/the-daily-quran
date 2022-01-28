package com.codefumes.thedailyquran.pages

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavHostController
import androidx.viewpager2.widget.ViewPager2
import com.codefumes.thedailyquran.data.SingleSupplication
import com.codefumes.thedailyquran.data.getAllSingleSupplications
import com.codefumes.thedailyquran.data.getAllSupplications
import com.codefumes.thedailyquran.layout.MainLayout
import com.codefumes.thedailyquran.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@ExperimentalMaterial3Api
@Composable
fun SingleSupplicationPage(modifier: Modifier = Modifier, navController: NavHostController, supplicationIndex: Int) {
    var supplicationAllList = getAllSupplications()

    val pagerState = rememberPagerState(supplicationIndex)

    MainLayout(navController = navController, content = {
        ScrollableTabRow(
            // Our selected tab is our current page
            selectedTabIndex = pagerState.currentPage,
            // Override the indicator, using the provided pagerTabIndicatorOffset modifier
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                )
            },
            backgroundColor = MaterialTheme.colorScheme.background,
            contentColor = orange1
        ) {
            // Add tabs for all of our pages
            supplicationAllList.forEachIndexed { index, item ->
                Tab(
                    text = { Text(item.title) },
                    selected = pagerState.currentPage == index,
                    onClick = {  },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        HorizontalPager(
            count = supplicationAllList.size,
            state = pagerState,
        ) { page ->
                LazyColumn(
                    modifier = Modifier.padding(top = 65.dp)
                ) {
                    items(supplicationAllList[page].singleSupplications.size) { index ->
                        SingleSupplicationTile(navController = navController, data = supplicationAllList[page].singleSupplications[index])
                        Spacer(modifier.size(25.dp))
                    }
                }
        }
    })
}

@Composable
fun SingleSupplicationTile(modifier: Modifier = Modifier, navController: NavHostController, data: SingleSupplication) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        color = Color.Transparent,
        modifier = Modifier.border(2.dp, pink1, RoundedCornerShape(15.dp))
    ) {
        Box() {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                color = Color.Transparent
            ) {
                Column(
                    modifier= Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = data.description,
                        style = MaterialTheme.typography.headlineSmall,
                        textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Spacer(modifier.size(12.dp))
                    Text(
                        text = data.arabic,
                        style = MaterialTheme.typography.headlineMedium,
                        textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth(),
                        fontFamily = NooreHudaFont,
                        color = pink1,
                        fontSize = 10.em,
                        lineHeight = 1.5.em,
                    )
                    Spacer(modifier.size(12.dp))
                    Text(
                        text = data.urdu,
                        style = MaterialTheme.typography.headlineSmall,
                        textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Spacer(modifier.size(12.dp))
                    Text(
                        text = data.reference,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth(),
                    )
                }

            }
        }
    }
}