package com.booksearch.core.model

import kotlinx.serialization.Serializable

@Serializable
data class SearchInfo(
    val textSnippet: String
)