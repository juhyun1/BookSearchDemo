package com.booksearch.core.data.repository

import com.booksearch.core.model.Item

interface SearchRepository {
    suspend fun search(keyword: String, startIndex: Int): List<Item>
    suspend fun totalCount(keyword: String): Int
}