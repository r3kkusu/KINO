package com.kino.app.data.remote

import okhttp3.ResponseBody
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
    ): ResponseBody
}