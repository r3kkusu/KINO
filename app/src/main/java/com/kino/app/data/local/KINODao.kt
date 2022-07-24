package com.kino.app.data.local

import androidx.room.*
import com.kino.app.data.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface KINODao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovie(movieEntities: List<MovieEntity>)

    @Update
    suspend fun updateMovie(movieEntity: MovieEntity)

    @Delete
    suspend fun deleteMovie(movieEntity: MovieEntity)

    @Query("SELECT * FROM movie_table")
    fun getMovies(): List<MovieEntity>

    @Query("SELECT * FROM movie_table WHERE liked = :liked")
    fun getMovies(liked: Boolean): List<MovieEntity>

    @Query("SELECT * FROM movie_table WHERE trackId == :trackId")
    fun getMovie(trackId: Int): MovieEntity

    @Query("DELETE FROM movie_table WHERE liked != 1")
    suspend fun clearMovies()
}