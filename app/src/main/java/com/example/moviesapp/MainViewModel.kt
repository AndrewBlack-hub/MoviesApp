package com.example.moviesapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.models.MoviesData
import com.example.moviesapp.data.network.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MoviesRepository) : ViewModel() {

    private val _allMovies = MutableLiveData<List<MoviesData>>()
    val allMovies: LiveData<List<MoviesData>>
        get() = _allMovies

    fun getAllMovies() {
        viewModelScope.launch {
            repository.getAllMovies().let {
                if (it.isSuccessful) {
                    _allMovies.postValue(it.body())
                } else {
                    Log.d("checkData", "Failed to load movies: ${it.errorBody()}")
                }
            }
        }
    }
}