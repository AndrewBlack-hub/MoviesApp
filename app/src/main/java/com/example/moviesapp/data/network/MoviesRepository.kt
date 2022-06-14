package com.example.moviesapp.data.network

import javax.inject.Inject

class MoviesRepository @Inject constructor(private val moviesService: MoviesService) {

    suspend fun getAllMovies() = moviesService.getAllMovies()
}