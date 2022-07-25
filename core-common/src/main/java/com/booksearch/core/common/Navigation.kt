package com.booksearch.core.common

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

class Navigation(private val navController: NavHostController) {

    fun navigateTo(route: String, args: String? = null, popup: Boolean = false) {

        val dest = if (args == null) {
            route
        } else {
            "$route/$args"
        }

        if (popup) {
            navController.popBackStack()
        }

        navController.navigate(dest) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = false
            restoreState = true
        }
    }
}

data class Destination(
    val route: String,
    val selectedColor: Color,
    val unselectedColor: Color,
    val title: Int
)
