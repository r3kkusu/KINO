package com.kino.app.data.local

import androidx.room.*
import com.kino.app.data.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface KINODao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movieEntities: List<MovieEntity>)

    @Delete
    suspend fun deleteMovie(movieEntity: MovieEntity)

    @Query("SELECT * FROM movie_table")
    fun getMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie_table WHERE liked = :liked")
    fun getMovies(liked: Boolean): Flow<List<MovieEntity>>
}