package com.kino.app.features.home.favorite

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kino.app.common.Resource
import com.kino.app.domain.model.Movie
import com.kino.app.domain.usecase.FavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val useCase: FavoriteUseCase
) : ViewModel() {

    var state by mutableStateOf(FavoriteState())
    var job : Job? = null

    init {
        getLikeMovies()
    }

    private fun getLikeMovies() {
        job?.cancel() // Cancel previous process
        job = viewModelScope.launch(Dispatchers.IO) {
            useCase.getLikeMovies(liked = true) // Set to true to get only liked movies
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
            useCase.searchMovies(title, liked = true) // Search for movies liked by user
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
                                getLikeMovies() // Reload data
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

    fun onEvent(event: FavoriteEvent) {
        when(event) {
            is FavoriteEvent.Search -> {
                searchMovies(title = event.title)
            }
            is FavoriteEvent.LikeMovie -> {
                likedMovie(movie = event.movie)
            }
        }
    }
}