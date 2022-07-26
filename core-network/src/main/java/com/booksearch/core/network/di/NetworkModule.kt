package com.booksearch.core.network.di

import com.booksearch.core.network.BookSearchDataSource
import com.booksearch.core.network.BookSearchService
import com.booksearch.core.network.retrofit.RetrofitBookSearchNetwork
import com.google.gson.GsonBuilder
import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://www.googleapis.com/books/v1/"

    @Singleton
    @Provides
    fun provideBookSearchService(): BookSearchService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(BookSearchService::class.java)
    }
}


@Module
@InstallIn(SingletonComponent::class)
interface NetworkDataSourceModule {
    @Binds
    fun bindsBookSearchDataSource(
        kioskNetworkDataSource: RetrofitBookSearchNetwork
    ): BookSearchDataSource
}