package com.booksearch.core.network.retrofit

import com.booksearch.core.network.BookSearchDataSource
import com.booksearch.core.network.BookSearchService
import com.booksearch.core.network.model.SearchResponse
import com.skydoves.sandwich.ApiResponse
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitBookSearchNetwork @Inject constructor(
    private val service: BookSearchService
) : BookSearchDataSource {
    override suspend fun search(keyword: String, startIndex: Int): ApiResponse<SearchResponse> = service.search(keyword = keyword, startIndex = startIndex)
}