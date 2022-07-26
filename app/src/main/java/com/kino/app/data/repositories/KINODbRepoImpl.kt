package com.kino.app.data.repositories

import com.kino.app.data.local.KINODatabase
import com.kino.app.data.local.entities.MovieEnt
import com.kino.app.domain.repositories.KINODbRepo
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class KINODbRepoImpl @Inject constructor(
    private val db: KINODatabase,
) : KINODbRepo {
    private val dao = db.dao

    override suspend fun insertMovie(movieEnts: List<MovieEnt>) {
        dao.insertMovies(movieEnts)
    }

    override suspend fun updateMovie(movieEnt: MovieEnt) {
        dao.updateMovie(movieEnt)
    }

    override suspend fun deleteMovie(movieEnt: MovieEnt) {
        dao.deleteMovie(movieEnt)
    }

    override fun getMovies(): List<MovieEnt> {
        return dao.getMovies()
    }

    override fun getMovies(liked: Boolean): List<MovieEnt> {
        return dao.getMovies(liked)
    }

    override fun getMovie(_id: String): MovieEnt {
        return dao.getMovie(_id)
    }

    override suspend fun clearMovies() {
        dao.clearMovies()
    }
}