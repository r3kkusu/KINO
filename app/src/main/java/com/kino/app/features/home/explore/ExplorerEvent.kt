package com.kino.app.features.home.explore

import com.kino.app.domain.model.Movie

sealed class ExplorerEvent {
    data class Search(val title: String) : ExplorerEvent()
    data class LikeMovie(val movie: Movie) : ExplorerEvent()
}