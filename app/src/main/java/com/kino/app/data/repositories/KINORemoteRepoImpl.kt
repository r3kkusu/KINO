package com.kino.app.data.repositories

import com.kino.app.data.remote.KINOApi
import com.kino.app.data.remote.dto.ResultDto
import com.kino.app.domain.repositories.KINORemoteRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KINORemoteRepoImpl @Inject constructor(
    private val api: KINOApi
) : KINORemoteRepo {
    override suspend fun getMovies(term: String, country: String): ResultDto {
        return api.getMovies(term, country)
    }
}