package com.booksearch.core.data.usecase

import com.booksearch.core.data.repository.SearchRepository
import javax.inject.Inject


class SearchTotalCountUseCase @Inject constructor(
    private val repository: SearchRepository
) {
    suspend operator fun invoke(keyword: String): Int = repository.totalCount(keyword = keyword)
}