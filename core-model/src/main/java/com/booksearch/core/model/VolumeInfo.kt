package com.booksearch.core.model

import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfo(
    val allowAnonLogging: Boolean? = null,
    val authors: List<String>? = null,
    val canonicalVolumeLink: String? = null,
    val contentVersion: String? = null,
    val description: String? = null,
    val imageLinks: ImageLinks? = null,
    val infoLink: String? = null,
    val maturityRating: String? = null,
    val panelizationSummary: PanelizationSummary? = null,
    val previewLink: String? = null,
    val publishedDate: String? = null,
    val publisher: String? = null,
    val readingModes: ReadingModes? = null,
    val subtitle: String? = null,
    val title: String
)