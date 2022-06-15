package com.example.moviesapp.screens

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.moviesapp.MainViewModel
import com.example.moviesapp.data.models.MoviesData
import com.example.moviesapp.ui.theme.MoviesAppTheme

@Composable
fun MovieListScreen(
    navController: NavController,
    viewModel: MainViewModel
) {
    val allMovies = viewModel.allMovies.observeAsState(listOf()).value
    allMovies.forEach { Log.d("checkData", "ID: ${it.id} name: ${it.name}") }
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(allMovies.take(10)) { item ->
                MovieItem(item = item)
            }
        }
    }
}

@Composable
fun MovieItem(item: MoviesData) {
    Row(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = "${item.id}) ")
        Text(text = item.name)
    }
}