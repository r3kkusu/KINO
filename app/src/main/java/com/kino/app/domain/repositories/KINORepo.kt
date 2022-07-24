package com.kino.app.domain.repositories

import com.kino.app.data.local.entity.MovieEntity
import com.kino.app.data.remote.dto.ResultDto

interface KINORepo {

    suspend fun getMovies(term: String, country: String): ResultDto

    suspend fun insertMovie(movieEntities: List<MovieEntity>)

    suspend fun updateMovie(movieEntity: MovieEntity)

    suspend fun deleteMovie(movieEntity: MovieEntity)

    fun getMovies(): List<MovieEntity>

    fun getMovies(liked: Boolean): List<MovieEntity>

    fun getMovie(trackId: Int): MovieEntity

    suspend fun clearMovies()
}