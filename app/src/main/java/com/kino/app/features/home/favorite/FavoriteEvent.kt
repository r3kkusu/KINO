package com.kino.app.features.home.favorite

import com.kino.app.domain.model.Movie

sealed class FavoriteEvent {
    data class Search(val title: String) : FavoriteEvent()
    data class LikeMovie(val movie: Movie) : FavoriteEvent()
}