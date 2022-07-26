package com.booksearch.feature.search

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import androidx.paging.compose.itemsIndexed
import com.booksearch.core.model.Item
import com.booksearch.core.ui.component.HeightSpacer
import com.booksearch.core.ui.component.ItemList
import java.security.KeyStore

@Composable
fun SearchScreenBody(navigateToDetails: (Item) -> Unit) {

    val vm: SearchViewModel = hiltViewModel()
    val pagingItems = vm.pager.value.flow.collectAsLazyPagingItems()

    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        SearchBar(vm = vm)
        PageCount(vm = vm)
        HeightSpacer(height = 10f)
        ItemList(vm = vm, navigateToDetails = navigateToDetails)

    }
}

@Composable
fun ItemList(vm: SearchViewModel, navigateToDetails: (Item) -> Unit) {
    val pagingItems = vm.pager.value.flow.collectAsLazyPagingItems()

    if (pagingItems.itemCount == 0) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .border(width = 1.dp, color = MaterialTheme.colorScheme.primary)
        ) {
            Text(
                text = stringResource(id = R.string.enter_title),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    } else {
        LazyColumn() {
            items(pagingItems) {item ->
                item?.let {
                    ItemList(
                        imageLinks = item.volumeInfo.imageLinks?.thumbnail,
                        title = item.volumeInfo.title,
                        description = item.volumeInfo.description,
                        extra = item.volumeInfo.publishedDate,
                        onClick = {
                            navigateToDetails(it)
                        }
                    )
                    HeightSpacer(height = 5f)
                }
            }
        }
    }
}

@Composable
fun PageCount(vm: SearchViewModel) {

    val state by vm.keywordState
    var totalCount by remember { mutableStateOf(0) }

    LaunchedEffect(key1 = state) {
        totalCount = when(state) {
            is SearchState.KeywordChanged -> {
                vm.getTotalCount(keyword = (state as SearchState.KeywordChanged).keyword)

            } else -> {
                0
            }
        }
    }

    Row{
        Text(
            text = "${stringResource(id = R.string.result)}($totalCount)",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }

}

@Composable
fun SearchBar(vm: SearchViewModel) {
    var text by remember { mutableStateOf("") }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, Color.Black)
        ,
        value = text,
        onValueChange = {
            text = it
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colorScheme.primary,
            containerColor = MaterialTheme.colorScheme.secondary
        ),
        trailingIcon = {
            Button(
                colors = ButtonDefaults.buttonColors( MaterialTheme.colorScheme.tertiary),
                shape = RoundedCornerShape(5.dp),
                onClick = {
                    if (text.isNotEmpty()) {
                        vm.onSearch(keyword = text)
                        text = ""
                    }
                }
            ) {
                Text(
                    text = stringResource(id = R.string.send),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    )

}