package com.kino.app.domain.usecase.queries

import com.kino.app.common.Resource
import com.kino.app.data.mapper.toMovieEntity
import com.kino.app.data.mapper.toMovieModel
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
    operator fun invoke(term: String, country: String) : Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading(true))
        val remoteMovies = try {
            kinoApiRepo.getMovies(term, country)
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
                movies.results.map { it.toMovieModel().toMovieEntity() }
            )
            emit(Resource.Success(
                data = kinoDbRepo.getMovies().map { it.toMovieModel() }
            ))
            emit(Resource.Loading(false))
        }
    }
}