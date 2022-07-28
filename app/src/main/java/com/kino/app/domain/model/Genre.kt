package com.kino.app.domain.model

data class Genre(
    var name: String,
    var uuid: String
) {
    companion object {
        fun stub(): Genre {
            return Genre("Comedia", "comedia")
        }
    }
}