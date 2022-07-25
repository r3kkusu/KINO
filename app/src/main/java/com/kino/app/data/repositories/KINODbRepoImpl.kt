package com.kino.app.data.repositories

import com.kino.app.data.local.KINODatabase
import com.kino.app.data.local.entity.MovieEntity
import com.kino.app.domain.repositories.KINODbRepo
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class KINODbRepoImpl @Inject constructor(
    private val db: KINODatabase,
) : KINODbRepo {
    private val dao = db.dao

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