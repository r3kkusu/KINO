package com.kino.app.domain.repositories

import com.kino.app.data.remote.dto.ResultDto

interface KINORemoteRepo {
    suspend fun getMovies(term: String, country: String): ResultDto
}