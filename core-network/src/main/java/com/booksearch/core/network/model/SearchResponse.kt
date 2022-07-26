package com.booksearch.core.network.model

data class SearchResponse(
    val items: List<ItemDto>,
    val kind: String,
    val totalItems: Int
)