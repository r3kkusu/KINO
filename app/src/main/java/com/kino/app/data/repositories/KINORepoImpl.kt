package com.kino.app.data.repositories

import com.kino.app.data.local.KINODatabase
import com.kino.app.data.local.entity.MovieEntity
import com.kino.app.data.remote.KINOApi
import com.kino.app.data.remote.dto.ResultDto
import com.kino.app.domain.repositories.KINORepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KINORepoImpl @Inject constructor(
    private val api: KINOApi,
    private val db: KINODatabase,
) : KINORepo {

    private val dao = db.dao

    override suspend fun getMovies(term: String, country: String): ResultDto {
        return api.getMovies(term, country)
    }

    override suspend fun insertMovie(movieEntities: List<MovieEntity>) {
        dao.insertMovie(movieEntities)
    }

    override suspend fun updateMovie(movieEntity: MovieEntity) {
        dao.updateMovie(movieEntity)
    }

    override suspend fun deleteMovie(movieEntity: MovieEntity) {
        dao.deleteMovie(movieEntity)
    }

    override fun getMovies(): List<MovieEntity> {
        return dao.getMovies()
    }

    override fun getMovies(liked: Boolean): List<MovieEntity> {
        return dao.getMovies(liked)
    }

    override fun getMovie(trackId: Int): MovieEntity {
        return dao.getMovie(trackId)
    }

    override suspend fun clearMovies() {
        dao.clearMovies()
    }

}