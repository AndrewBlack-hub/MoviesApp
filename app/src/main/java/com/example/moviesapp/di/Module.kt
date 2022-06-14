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

    private const val BASE_URL = "https://api.tvmaze.com/"

    @Provides
    @Singleton
    fun provideRetrofit() : MoviesService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesService::class.java)
}