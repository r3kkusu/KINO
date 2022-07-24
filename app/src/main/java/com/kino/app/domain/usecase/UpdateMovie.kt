package com.kino.app.domain.usecase

import com.kino.app.common.Resource
import com.kino.app.data.mapper.toMovieEntity
import com.kino.app.data.mapper.toMovieModel
import com.kino.app.domain.model.Movie
import com.kino.app.domain.repositories.KINORepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class UpdateMovie(
    private val localRepo: KINORepo
) {
    operator fun invoke(movie: Movie): Flow<Resource<Movie>> {
        return flow {
            emit(Resource.Loading(true))
            val localMovies = try {
                localRepo.updateMovie(movie.toMovieEntity())
                localRepo.getMovie(movie.trackId).toMovieModel()
            } catch(e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }
            localMovies?.let { movie -> emit(Resource.Success(movie)) }
            emit(Resource.Loading(false))
        }
    }
}