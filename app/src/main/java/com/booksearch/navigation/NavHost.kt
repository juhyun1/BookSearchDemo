package com.booksearch.navigation

import SplashDestination
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.booksearch.core.common.Navigation
import com.booksearch.feature.search.navigation.SearchDestination
import com.booksearch.feature.search.navigation.searchGraph
import splashGraph

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun NavHost(
    innerPadding: PaddingValues,
    navController: NavHostController = rememberNavController(),
    startDestination: String = SplashDestination.route
) {

    BoxWithConstraints(
        modifier = Modifier
            .padding(innerPadding)
            .consumedWindowInsets(innerPadding)
    ) {

        val navigation = remember(navController) {
            Navigation(navController)
        }

        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier,
        ) {
            splashGraph(
                navigateBookSearch = {
                    navigation.navigateTo(SearchDestination.route, popup = true)
                }
            )

            searchGraph(
                navigateToDetails = {

                }
            )
        }
    }
}
