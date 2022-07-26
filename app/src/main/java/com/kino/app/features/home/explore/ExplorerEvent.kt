package com.kino.app.features.home.explore

sealed class ExplorerEvent {
    data class Search(val term: String) : ExplorerEvent()
    data class LikeMovie(val like: Boolean) : ExplorerEvent()
}