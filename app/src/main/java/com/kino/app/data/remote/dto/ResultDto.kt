package com.kino.app.data.remote.dto

data class ResultDto(
    val messageStatus: String,
    val results: List<MovieDto>,
    val status: Int,
    val success: Boolean,
    val total_pages: Int,
    val total_results: Int
)