package com.booksearch.feature.search

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import com.booksearch.core.model.Item

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchRoute(navigateToDetails: (Item) -> Unit) {
    SearchScreenBody(navigateToDetails = navigateToDetails)
}
