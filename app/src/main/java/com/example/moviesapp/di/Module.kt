package com.example.moviesapp.di

import com.example.moviesapp.data.network.MoviesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    fun baseUrl() = "https://api.tvmaze.com/"

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String) : MoviesService =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesService::class.java)
}