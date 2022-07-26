package com.booksearch.core.network

import com.booksearch.core.network.model.SearchResponse
import com.skydoves.sandwich.ApiResponse

interface BookSearchDataSource {

    suspend fun search(keyword: String, startIndex: Int = 0): ApiResponse<SearchResponse>

}