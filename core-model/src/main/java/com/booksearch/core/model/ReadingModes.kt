package com.booksearch.core.model

import kotlinx.serialization.Serializable

@Serializable
data class ReadingModes(
    val image: Boolean,
    val text: Boolean
)