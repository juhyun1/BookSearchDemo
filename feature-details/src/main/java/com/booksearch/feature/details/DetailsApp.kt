package com.booksearch.feature.details

import android.annotation.SuppressLint
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import com.booksearch.core.model.Item
import com.booksearch.core.ui.theme.BookSearchTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsApp(windowSizeClass: WindowSizeClass, item: Item) {
    BookSearchTheme {
        DetailsScreen(item = item)
    }
}
