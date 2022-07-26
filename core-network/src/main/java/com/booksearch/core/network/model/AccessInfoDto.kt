package com.booksearch.core.network.model

data class AccessInfoDto(
    val accessViewStatus: String,
    val country: String,
    val epub: EpubDto,
    val pdf: PdfDto
)