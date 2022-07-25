package com.booksearch.feature.search.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.booksearch.core.common.NavigationDestination
import com.booksearch.feature.search.SearchRoute

object SearchDestination : NavigationDestination {
    override val route = "search_route"
    override val destination = "search_destination"
}

fun NavGraphBuilder.searchGraph(navigateToDetails: () -> Unit) {
    composable(route = SearchDestination.route) {
        SearchRoute(navigateToDetails = navigateToDetails)
    }
}
