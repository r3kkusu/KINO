package com.kino.app.domain.usecase.queries

import com.kino.app.common.Resource
import com.kino.app.data.mapper.toMovie
import com.kino.app.domain.model.Movie
import com.kino.app.domain.repositories.KINODbRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class GetLikeMovies(
    private val kinoDbRepo: KINODbRepo
) {
    operator fun invoke(liked: Boolean): Flow<Resource<List<Movie>>> {
        return flow {
            emit(Resource.Loading(true))
            val localMovies = try {
                kinoDbRepo.getMovies(liked).map { it.toMovie() }
            } catch(e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }
            localMovies?.let { movies -> emit(Resource.Success(movies)) }
            emit(Resource.Loading(false))
        }
    }
}