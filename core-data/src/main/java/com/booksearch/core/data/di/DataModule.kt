package com.booksearch.core.data.di

import com.booksearch.core.data.repository.SearchRepository
import com.booksearch.core.data.repository.SearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsSearchRepository(
        searchRepository: SearchRepositoryImpl
    ): SearchRepository
}
