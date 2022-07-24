package com.kino.app.domain.usecase

import com.kino.app.common.Resource
import com.kino.app.data.mapper.toMovieEntity
import com.kino.app.data.mapper.toMovieModel
import com.kino.app.domain.model.Movie
import com.kino.app.domain.repositories.KINOLocalRepo
import com.kino.app.domain.repositories.KINORemoteRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetMovies(
    private val remoteRepo: KINORemoteRepo,
    private val localRepo: KINOLocalRepo
) {
    operator fun invoke(term: String, country: String) : Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading(true))
        val remoteMovies = try {
            remoteRepo.getMovies(term, country)
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
            localRepo.clearMovies()
            localRepo.insertMovie(
                movies.results.map { it.toMovieModel().toMovieEntity() }
            )
            emit(Resource.Success(
                data = localRepo.getMovies().map { it.toMovieModel() }
            ))
            emit(Resource.Loading(false))
        }
    }
}