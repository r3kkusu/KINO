package com.kino.app.data.repositories

import com.kino.app.data.remote.KINOApi
import com.kino.app.data.remote.dto.ResultDto
import com.kino.app.domain.repositories.KINOApiRepo
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class KINOApiRepoImpl @Inject constructor(
    private val api: KINOApi
) : KINOApiRepo {

    override suspend fun getMovies(): ResultDto {
        return api.getMovies()
    }
}