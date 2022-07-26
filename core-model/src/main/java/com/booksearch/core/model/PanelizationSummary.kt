package com.booksearch.core.model

import kotlinx.serialization.Serializable

@Serializable
data class PanelizationSummary(
    val containsEpubBubbles: Boolean,
    val containsImageBubbles: Boolean
)