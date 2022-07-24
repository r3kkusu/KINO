package com.kino.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kino.app.data.local.entity.MovieEntity

@Database(
    entities = [MovieEntity::class],
    version = 2
)
abstract class KINODatabase: RoomDatabase() {
    abstract val dao: KINODao

    companion object {
        const val DATABASE_NAME = "kino_db"
    }
}