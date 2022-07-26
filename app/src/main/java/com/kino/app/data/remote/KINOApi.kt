package com.kino.app.data.remote

import com.kino.app.data.remote.dto.ResultDto
import retrofit2.http.GET
import retrofit2.http.Headers

interface KINOApi {

    companion object {
        const val BASE_URL = "https://movies-app1.p.rapidapi.com"
        const val RAPID_KEY = ""
        const val RAPID_HOST = ""
    }

    @Headers(
        "X-RapidAPI-Key: $RAPID_KEY",
        "X-RapidAPI-Host: $RAPID_HOST"
    )
    @GET("/api/movies")
    suspend fun getMovies(): ResultDto
}