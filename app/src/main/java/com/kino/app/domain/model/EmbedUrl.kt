package com.kino.app.domain.model

data class EmbedUrl(
    var uuid: Int,
    var priority: Int,
    var server: String,
    var url: String
) {
    companion object {
        fun stub() : EmbedUrl {
            return EmbedUrl(1, 4, "fembed", "https://dutrag.com/v/1ezegcjmn787gd6")
        }
    }
}