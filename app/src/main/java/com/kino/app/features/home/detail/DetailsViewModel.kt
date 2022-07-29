package com.kino.app.features.home.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kino.app.common.Resource
import com.kino.app.domain.model.Movie
import com.kino.app.domain.usecase.DetailsUseCase
import com.kino.app.features.home.explore.ExplorerEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCase: DetailsUseCase
) : ViewModel() {

    companion object {
        var movieId: String = "<stub>"
    }

    var state by mutableStateOf(DetailsState())
    var job : Job? = null

    init {
        getMovie()
    }

    private fun getMovie() {
        job?.cancel() // Cancel previous process
        job = viewModelScope.launch(Dispatchers.IO) {
            useCase.getMovie(movieId)
                .collect { result ->
                    withContext(Dispatchers.Main) {
                        when(result) {
                            is Resource.Success -> {
                                result.data?.let { movie ->
                                    state = state.copy(movie = movie)
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
                                result.data?.let { movie ->
                                    state = state.copy(movie = movie)
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

    fun onEvent(event: DetailsEvent) {
        when(event) {
            is DetailsEvent.LikeMovie -> {
                likedMovie(movie = event.movie)
            }
        }
    }
}
