package com.kino.app.features.home.detail

import com.kino.app.domain.model.Movie

data class DetailsState(
    val isLoading: Boolean = false,
    val movie: Movie = Movie.stub(),
    val error: String = ""
)
