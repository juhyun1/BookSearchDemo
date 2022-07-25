package com.booksearch.feature.splash

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SplashRoute(navigateBookSearch: () -> Unit) {
    SplashScreenBody(navigateBookSearch = navigateBookSearch)
}
