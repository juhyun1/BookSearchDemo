package com.booksearch.core.network

import com.booksearch.core.network.model.SearchResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface BookSearchService {

    @GET("volumes")
    suspend fun search(
        @Query("q") keyword: String,
        @Query("startIndex") startIndex: Int = 0, //The index of the first item is 0.
        @Query("maxResults") maxResults: Int = 30, //The default is 10, and the maximum allowable value is 40.
        @Query("projection") projection: String = "lite"
    ): ApiResponse<SearchResponse>
}
