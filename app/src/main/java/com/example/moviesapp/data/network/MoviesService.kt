package com.example.moviesapp.data.network

import com.example.moviesapp.data.models.MoviesData
import retrofit2.Response
import retrofit2.http.GET

interface MoviesService {

    @GET("shows")
    suspend fun getAllMovies(): Response<List<MoviesData>>
}