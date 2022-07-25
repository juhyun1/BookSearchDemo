package com.booksearch.feature.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SearchScreenBody(navigateToDetails: () -> Unit) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "This Screen is Search Screen")
    }
}