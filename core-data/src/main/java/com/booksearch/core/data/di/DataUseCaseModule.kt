package com.booksearch.core.data.di

import com.booksearch.core.data.repository.SearchRepository
import com.booksearch.core.data.usecase.SearchTotalCountUseCase
import com.booksearch.core.data.usecase.SearchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DataUseCaseModule {
    @Provides
    fun provideSearchUseCase(
        repository: SearchRepository,
    ): SearchUseCase {
        return SearchUseCase(repository = repository)
    }

    @Provides
    fun provideSearchTotalCountUseCase(
        repository: SearchRepository,
    ): SearchTotalCountUseCase {
        return SearchTotalCountUseCase(repository = repository)
    }
}
