package com.kino.app.domain.usecase.queries

import com.kino.app.common.Resource
import com.kino.app.data.mapper.toMovie
import com.kino.app.data.mapper.toMovieEnt
import com.kino.app.domain.model.Movie
import com.kino.app.domain.repositories.KINODbRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class UpdateMovie(
    private val kinoDbRepo: KINODbRepo
) {
    operator fun invoke(movie: Movie): Flow<Resource<Movie>> {
        return flow {
            emit(Resource.Loading(true))
            val localMovies = try {
                kinoDbRepo.updateMovie(movie.toMovieEnt())
                kinoDbRepo.getMovie(movie._id).toMovie()
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