package com.kino.app.domain.usecase

import com.kino.app.common.Resource
import com.kino.app.data.mapper.toMovieModel
import com.kino.app.domain.model.Movie
import com.kino.app.domain.repositories.KINORepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class GetLikeMovies(
    private val localRepo: KINORepo
) {
    operator fun invoke(liked: Boolean): Flow<Resource<List<Movie>>> {
        return flow {
            emit(Resource.Loading(true))
            val localMovies = try {
                localRepo.getMovies(liked).map { it.toMovieModel() }
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