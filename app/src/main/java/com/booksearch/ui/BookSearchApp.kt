package com.booksearch.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.booksearch.MainViewModel
import com.booksearch.R
import com.booksearch.core.common.Navigation
import com.booksearch.core.ui.component.TopAppBar
import com.booksearch.core.ui.theme.BookSearchTheme
import com.booksearch.feature.splash.SplashScreenBody
import com.booksearch.navigation.NavHost

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)

@Composable
fun BookSearchApp(vm: MainViewModel) {
    BookSearchTheme {
        val navController = rememberNavController()
        val navigation = remember(navController) {
            Navigation(navController)
        }

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        val state by vm.done

        if (!state) {
            SplashScreenBody()
        } else{
            Scaffold(
                modifier = Modifier,
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onBackground,
                topBar = {
                    BookSearchTopBar()
                },
            ) { innerPadding ->
                Row(
                    Modifier
                        .fillMaxSize()
                        .windowInsetsPadding(
                            WindowInsets.safeDrawing.only(
                                WindowInsetsSides.Horizontal
                            )
                        )
                ) {
                    NavHost(
                        innerPadding = innerPadding,
                        navController = navController,
                    )
                }
            }
        }
    }
}

@Composable
fun BookSearchTopBar() {
    TopAppBar(
        titleRes = R.string.app_name,
        navigationIcon = Icons.Filled.Search,
        navigationIconContentDescription = "navigationIconContentDescription",
        actionIcon = Icons.Outlined.AccountCircle,
        actionIconContentDescription = "actionIconContentDescription",
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier.windowInsetsPadding(
            WindowInsets.safeDrawing.only(WindowInsetsSides.Top)
        ),
        onActionClick = {}
    )
}