package com.kino.app.domain.repositories

import com.kino.app.data.local.entities.MovieEnt

interface KINODbRepo {
    suspend fun insertMovie(movieEnts: List<MovieEnt>)

    suspend fun updateMovie(movieEnt: MovieEnt)

    suspend fun deleteMovie(movieEnt: MovieEnt)

    fun getMovies(): List<MovieEnt>

    fun getMovies(liked: Boolean): List<MovieEnt>

    fun getMovie(_id: String): MovieEnt

    suspend fun clearMovies()
}