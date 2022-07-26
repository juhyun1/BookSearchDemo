package com.booksearch.core.model

import kotlinx.serialization.Serializable

@Serializable
data class AccessInfo(
    val accessViewStatus: String,
    val country: String,
    val epub: Epub,
    val pdf: Pdf
)