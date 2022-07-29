package com.kino.app.features.home.detail

import com.kino.app.domain.model.Movie

sealed class DetailsEvent {
    data class LikeMovie(val movie: Movie) : DetailsEvent()
}