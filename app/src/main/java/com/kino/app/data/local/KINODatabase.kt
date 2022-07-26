package com.kino.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kino.app.data.local.converters.CountryConverter
import com.kino.app.data.local.converters.EmbedUrlConverter
import com.kino.app.data.local.converters.GenreConverter
import com.kino.app.data.local.converters.StringConverter
import com.kino.app.data.local.entities.CountryEnt
import com.kino.app.data.local.entities.EmbedUrlEnt
import com.kino.app.data.local.entities.GenreEnt
import com.kino.app.data.local.entities.MovieEnt

@Database(
    entities = [
        MovieEnt::class,
        CountryEnt::class,
        EmbedUrlEnt::class,
        GenreEnt::class
    ],
    version = 5
)
@TypeConverters(
    StringConverter::class,
    CountryConverter::class,
    EmbedUrlConverter::class,
    GenreConverter::class
)
abstract class KINODatabase: RoomDatabase() {
    abstract val dao: KINODao

    companion object {
        const val DATABASE_NAME = "kino_db"
    }
}