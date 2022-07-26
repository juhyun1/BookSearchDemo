package com.booksearch.core.network.model

data class VolumeInfoDto(
    val allowAnonLogging: Boolean?,
    val authors: List<String>?,
    val canonicalVolumeLink: String?,
    val contentVersion: String?,
    val description: String?,
    val imageLinks: ImageLinksDto?,
    val infoLink: String?,
    val maturityRating: String?,
    val panelizationSummary: PanelizationSummaryDto?,
    val previewLink: String?,
    val publishedDate: String?,
    val publisher: String?,
    val readingModes: ReadingModesDto?,
    val subtitle: String?,
    val title: String
)