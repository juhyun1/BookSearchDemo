package com.booksearch.core.data.di

import com.booksearch.core.data.datasource.SearchDataSource
import com.booksearch.core.data.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    fun providesSearchDataSource(
        repository: SearchRepository
    ): SearchDataSource {
        return SearchDataSource(repository = repository)
    }
}
