package com.booksearch.feature.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.booksearch.core.data.datasource.SearchDataSource
import com.booksearch.core.data.usecase.SearchTotalCountUseCase
import com.booksearch.core.data.usecase.SearchUseCase
import com.booksearch.core.model.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase,
    private val searchTotalCountUseCase: SearchTotalCountUseCase,
    private val searchDataSource: SearchDataSource
) : ViewModel() {

    private val _keywordState = mutableStateOf<SearchState>(SearchState.Init)
    val keywordState get() = _keywordState

    private val _pager = mutableStateOf(Pager(
        PagingConfig(
            pageSize = 20,
            enablePlaceholders = true,
            maxSize = 1000
        )
    ) { searchDataSource})

    val pager get() = _pager

    suspend fun getTotalCount(keyword: String): Int = searchTotalCountUseCase(keyword = keyword)

    suspend fun search(keyword: String): Flow<List<Item>> {
        return flow {
            searchUseCase.invoke(keyword = keyword).collect {
                emit(value = it)
            }
        }
    }

    fun onSearch(keyword: String) {
        _pager.value = Pager(
            PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                maxSize = 1000
            )
        ) { searchDataSource.apply {
                this.setKeyword(keyword = keyword)
            }
        }

        _keywordState.value = SearchState.KeywordChanged(keyword = keyword)
    }

    fun initState() {
        _keywordState.value = SearchState.Init
    }
}

sealed class SearchState() {
    object Init : SearchState()
    data class KeywordChanged(val keyword: String) : SearchState()
}