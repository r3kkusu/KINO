package com.kino.app.data.remote

import com.kino.app.data.remote.dto.ResultDto
import retrofit2.http.GET
import retrofit2.http.Query

interface KINOApi {

    companion object {
        const val BASE_URL = "https://itunes.apple.com"
    }

    @GET("search?media=movie")
    suspend fun getMovies(
        @Query("term") term: String,
        @Query("country") country: String,
    ): ResultDto
}