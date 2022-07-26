package com.booksearch.core.model

import kotlinx.serialization.Serializable

@Serializable
data class Epub(
    val isAvailable: Boolean
)