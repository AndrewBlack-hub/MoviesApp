package com.example.moviesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviesapp.MainViewModel
import com.example.moviesapp.screens.MovieListScreen
import com.example.moviesapp.screens.SplashScreen
import com.example.moviesapp.utils.Constants

sealed class Screens(val route: String) {
    object Splash: Screens(Constants.Screens.SPLASH_SCREEN)
    object MovieList: Screens(Constants.Screens.MOVIE_LIST_SCREEN)
    object Details: Screens(Constants.Screens.DETAILS_SCREEN)
}

@Composable
fun SetupNavHost(
    navController: NavHostController,
    viewModel: MainViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screens.MovieList.route) {
            MovieListScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screens.Details.route) {

        }
    }
}