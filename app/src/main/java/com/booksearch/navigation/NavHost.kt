package com.booksearch.navigation

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.booksearch.core.common.Navigation
import com.booksearch.core.common.ext.encodeToString
import com.booksearch.core.model.Item
import com.booksearch.feature.details.DetailsActivity
import com.booksearch.feature.search.navigation.SearchDestination
import com.booksearch.feature.search.navigation.searchGraph

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun NavHost(
    innerPadding: PaddingValues,
    navController: NavHostController = rememberNavController(),
    startDestination: String = SearchDestination.route
) {

    val context = LocalContext.current
    BoxWithConstraints(
        modifier = Modifier
            .padding(innerPadding)
            .consumedWindowInsets(innerPadding)
    ) {

        val navigation = remember(navController) {
            Navigation(navController)
        }
        val navigateToDetails: (Item) -> Unit = { item ->
            val intent = Intent(context, DetailsActivity::class.java)
            val itemStr = encodeToString(value = item)
            intent.putExtra("item", itemStr)
            context.startActivity(intent)
        }


        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier,
        ) {
            searchGraph(
                navigateToDetails = {
                    navigateToDetails(it)
                }
            )
        }
    }
}
