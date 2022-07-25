package com.booksearch.feature.search

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchRoute(navigateToDetails: () -> Unit) {
    SearchScreenBody(navigateToDetails = navigateToDetails)
}
