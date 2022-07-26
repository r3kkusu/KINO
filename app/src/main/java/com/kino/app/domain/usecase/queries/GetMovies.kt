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

class GetMovies(
    private val kinoDbRepo: KINODbRepo,
    private val kinoApiRepo: KINOApiRepo

) {
    operator fun invoke() : Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading(true))
        val remoteMovies = try {
            kinoApiRepo.getMovies()
        } catch(e: IOException) {
            e.printStackTrace()
            emit(Resource.Error("Couldn't load data"))
            null
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error("Couldn't load data"))
            null
        }

        remoteMovies?.let { movies ->
            kinoDbRepo.clearMovies()
            kinoDbRepo.insertMovie(
                movies.results.map { it.toMovie().toMovieEnt() }
            )
            emit(Resource.Success(
                data = kinoDbRepo.getMovies().map { it.toMovie() }
            ))
            emit(Resource.Loading(false))
        }
    }
}