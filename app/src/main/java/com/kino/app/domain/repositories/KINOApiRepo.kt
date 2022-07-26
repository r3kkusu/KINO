package com.kino.app.domain.repositories

import com.kino.app.data.remote.dto.ResultDto

interface KINOApiRepo {
    suspend fun getMovies(): ResultDto
}