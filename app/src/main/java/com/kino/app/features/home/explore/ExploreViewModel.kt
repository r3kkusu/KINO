package com.kino.app.features.home.explore

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kino.app.common.Resource
import com.kino.app.domain.model.Movie
import com.kino.app.domain.usecase.ExploreUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val useCase: ExploreUseCase
    ) : ViewModel() {

    var state by mutableStateOf(ExplorerState())
    var job : Job? = null

    init {
        getMovies()
    }

    private fun getMovies() {
        job?.cancel() // Cancel previous process
        job = viewModelScope.launch(Dispatchers.IO) {
            useCase.getMovies()
                .collect { result ->
                    withContext(Dispatchers.Main) {
                        when(result) {
                            is Resource.Success -> {
                                result.data?.let { movies ->
                                    state = state.copy(movies = movies)
                                }
                            }
                            is Resource.Error -> Unit
                            is Resource.Loading -> {
                                state = state.copy(isLoading = result.isLoading)
                            }
                        }
                    }
                }
        }
    }

    @OptIn(FlowPreview::class)
    private fun searchMovies(title: String) {
        job?.cancel() // Cancel previous process
        job = viewModelScope.launch(Dispatchers.IO) {
            delay(200) // Avoid continues queries
            useCase.searchMovies(title)
                .collect { result ->
                    withContext(Dispatchers.Main) {
                        when(result) {
                            is Resource.Success -> {
                                result.data?.let { movies ->
                                    state = state.copy(movies = movies)
                                }
                            }
                            is Resource.Error -> Unit
                            is Resource.Loading -> {
                                state = state.copy(isLoading = result.isLoading)
                            }
                        }
                    }
                }
        }
    }

    private fun likedMovie(movie: Movie) {
        job?.cancel() // Cancel previous process
        job = viewModelScope.launch(Dispatchers.IO) {
            useCase.updateMovie(movie)
                .collect { result ->
                    withContext(Dispatchers.Main) {
                        when(result) {
                            is Resource.Success -> {
                                val movies = emptyList<Movie>().toMutableList()
                                state.movies.forEach {
                                    movies.add(if (it._id == movie._id) movie else it)
                                }
                                state = state.copy(movies = movies)
                            }
                            is Resource.Error -> Unit
                            is Resource.Loading -> {
                                state = state.copy(isLoading = result.isLoading)
                            }
                        }
                    }
                }
        }
    }

    fun onEvent(event: ExplorerEvent) {
        when(event) {
            is ExplorerEvent.Search -> {
                searchMovies(title = event.title)
            }
            is ExplorerEvent.LikeMovie -> {
                likedMovie(movie = event.movie)
            }
        }
    }
}