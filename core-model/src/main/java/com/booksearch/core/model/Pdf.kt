package com.booksearch.core.model

import kotlinx.serialization.Serializable

@Serializable
data class Pdf(
    val isAvailable: Boolean
)