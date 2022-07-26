package com.kino.app.domain.model

data class EmbedUrl(
    var uuid: Int,
    var priority: Int,
    var server: String,
    var url: String
)