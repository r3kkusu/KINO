package com.kino.app.domain.usecase.queries

import com.kino.app.common.Resource
import com.kino.app.data.mapper.toMovie
import com.kino.app.data.mapper.toMovieEnt
import com.kino.app.domain.model.Movie
import com.kino.app.domain.repositories.KINOApiRepo
import com.kino.app.domain.repositories.KINODbRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class SearchMovies(
    private val kinoDbRepo: KINODbRepo
) {
    operator fun invoke(title: String, liked: Boolean? = null) : Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading(true))
        val localMovies = try {
            if (liked != null) {
                if (title.isEmpty())
                    kinoDbRepo.getMovies(liked = true).map { it.toMovie() }
                else kinoDbRepo.getMovies(title, liked = true).map { it.toMovie() }
            } else {
                if (title.isEmpty())
                    kinoDbRepo.getMovies().map { it.toMovie() }
                else kinoDbRepo.getMovies(title).map { it.toMovie() }
            }
        } catch(e: IOException) {
            e.printStackTrace()
            emit(Resource.Error("Couldn't load data"))
            null
        }
        localMovies?.let { movies -> emit(Resource.Success(movies)) }
        emit(Resource.Loading(false))
    }
}