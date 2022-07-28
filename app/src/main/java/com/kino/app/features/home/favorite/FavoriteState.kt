package com.kino.app.features.home.favorite

import com.kino.app.domain.model.Movie

data class FavoriteState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = ""
)
