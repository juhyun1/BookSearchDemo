package com.booksearch.core.data.repository

import com.booksearch.core.data.mapper.asModel
import com.booksearch.core.model.Item
import com.booksearch.core.network.BookSearchDataSource
import com.skydoves.sandwich.getOrNull
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val bookSearchDataSource: BookSearchDataSource
) : SearchRepository {
    override suspend fun search(keyword: String, startIndex: Int): List<Item> {
        val response = bookSearchDataSource.search(keyword = keyword, startIndex = startIndex)
        return response.getOrNull()?.items?.map { it.asModel() } ?: emptyList()
//        response.onSuccess {
//            data.items
//        }
//        return response.toFlow().map { res ->
//            res.items.map {
//                it.asModel()
//            }
//        }
    }

    override suspend fun totalCount(keyword: String): Int {
        val result = bookSearchDataSource.search(keyword = keyword)
        return result.getOrNull()?.totalItems ?: 0
    }
}