package com.booksearch.core.network.model

data class ItemDto(
    val accessInfo: AccessInfoDto,
    val etag: String,
    val id: String,
    val kind: String,
    val saleInfo: SaleInfoDto,
    val searchInfo: SearchInfoDto? = null,
    val selfLink: String,
    val volumeInfo: VolumeInfoDto
)