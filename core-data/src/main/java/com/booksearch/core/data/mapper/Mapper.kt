package com.booksearch.core.data.mapper

import com.booksearch.core.model.*
import com.booksearch.core.network.model.*

fun AccessInfoDto.asModel(): AccessInfo {
    return AccessInfo(
        accessViewStatus = this.accessViewStatus,
        country = this.country,
        epub = this.epub.asModel(),
        pdf = this.pdf.asModel()
    )
}

fun EpubDto.asModel(): Epub {
    return Epub(
        isAvailable = this.isAvailable
    )
}

fun ImageLinksDto.asModel(): ImageLinks {
    return ImageLinks(
        smallThumbnail = this.smallThumbnail,
        thumbnail = this.thumbnail
    )
}

fun ItemDto.asModel(): Item {
    return Item(
        accessInfo = accessInfo.asModel(),
        etag = this.etag,
        id = this.id,
        kind = this.kind,
        saleInfo = saleInfo.asModel(),
        searchInfo = searchInfo?.asModel(),
        selfLink = this.selfLink,
        volumeInfo = volumeInfo.asModel()
    )
}

fun PanelizationSummaryDto.asModel(): PanelizationSummary {
    return PanelizationSummary(
        containsEpubBubbles = this.containsEpubBubbles,
        containsImageBubbles = this.containsImageBubbles
    )
}

fun PdfDto.asModel(): Pdf {
    return Pdf(
        isAvailable = this.isAvailable
    )
}

fun ReadingModesDto.asModel(): ReadingModes {
    return ReadingModes(
        image = this.image,
        text = this.text
    )
}

fun SaleInfoDto.asModel(): SaleInfo {
    return SaleInfo(
        country = this.country
    )
}

fun SearchInfoDto.asModel(): SearchInfo {
    return SearchInfo(
        textSnippet = this.textSnippet
    )
}

fun VolumeInfoDto.asModel(): VolumeInfo {

    return VolumeInfo(
        allowAnonLogging = this.allowAnonLogging,
        authors = this.authors,
        canonicalVolumeLink = this.canonicalVolumeLink,
        contentVersion = this.contentVersion,
        description = this.description,
        imageLinks = this.imageLinks?.asModel(),
        infoLink = this.infoLink,
        maturityRating = this.maturityRating,
        panelizationSummary = this.panelizationSummary?.asModel(),
        previewLink = this.previewLink,
        publishedDate = this.publishedDate,
        publisher = this.publisher,
        readingModes = this.readingModes?.asModel(),
        subtitle = this.subtitle,
        title = this.title
    )
}