package com.booksearch.core.data.usecase

import com.booksearch.core.data.repository.SearchRepository
import com.booksearch.core.model.Item
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchUseCase(
    private val repository: SearchRepository,
) {
    suspend operator fun invoke(keyword: String): Flow<List<Item>> {
        return flow {
            repository.search(keyword = keyword, startIndex = 0)
        }
    }
}