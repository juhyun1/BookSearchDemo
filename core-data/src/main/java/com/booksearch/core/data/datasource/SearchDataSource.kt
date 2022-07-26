package com.booksearch.core.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.booksearch.core.data.repository.SearchRepository
import com.booksearch.core.model.Item

class SearchDataSource(private val repository: SearchRepository) : PagingSource<Int, Item>() {

    private var keyword = ""

    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    fun setKeyword(keyword: String) {
        this.keyword = keyword
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        return try {
            val nextPageNumber = params.key ?: 0
            val pageData = repository.search(keyword = keyword, startIndex = nextPageNumber * 30)

            LoadResult.Page(
                data = pageData,
                prevKey = null,
                nextKey = nextPageNumber + 1
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }
}