package com.kino.app.features.home.explore

import com.kino.app.domain.model.Movie

data class ExplorerState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = ""
)
