package com.kino.app.data.local

import androidx.room.*
import com.kino.app.data.local.entities.CountryEnt
import com.kino.app.data.local.entities.EmbedUrlEnt
import com.kino.app.data.local.entities.GenreEnt
import com.kino.app.data.local.entities.MovieEnt

@Dao
interface KINODao {

    // Movies
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovies(movieEnts: List<MovieEnt>)

    @Update
    suspend fun updateMovie(movieEnt: MovieEnt)

    @Delete
    suspend fun deleteMovie(movieEnt: MovieEnt)

    @Query("SELECT * FROM movie_table")
    fun getMovies(): List<MovieEnt>

    @Query("SELECT * FROM movie_table WHERE liked = :liked")
    fun getMovies(liked: Boolean): List<MovieEnt>

    @Query("SELECT * FROM movie_table WHERE _id == :id")
    fun getMovie(id: String): MovieEnt

    @Query("DELETE FROM movie_table WHERE liked != 1")
    suspend fun clearMovies()

    // Countries
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCountries(countryEnts: List<CountryEnt>)

    @Query("SELECT * FROM country_table WHERE uuid IN (:uuids)")
    fun getCountries(uuids: List<String>): List<CountryEnt>

    // Genre
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGenre(genreEnts: List<GenreEnt>)

    @Query("SELECT * FROM genre_table WHERE uuid IN (:uuids)")
    fun getGenres(uuids: List<String>): List<GenreEnt>

    // EmbedUrl
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertEmbedUrl(embedUrlEnts: List<EmbedUrlEnt>)

    @Query("SELECT * FROM embed_url_table WHERE uuid IN (:uuids)")
    fun getEmbedUrl(uuids: List<String>): List<EmbedUrlEnt>
}