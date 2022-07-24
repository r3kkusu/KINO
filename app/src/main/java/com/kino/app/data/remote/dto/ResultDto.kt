package com.kino.app.data.remote.dto

data class ResultDto(
    val resultCount: Int,
    val results: List<MovieDto>
)