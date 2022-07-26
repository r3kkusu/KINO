package com.kino.app.data.remote.dto

data class EmbedUrlDto(
    var uuid: Int,
    var priority: Int,
    var server: String,
    var url: String
)