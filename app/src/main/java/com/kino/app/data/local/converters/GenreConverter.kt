package com.kino.app.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kino.app.data.local.entities.GenreEnt

class GenreConverter {
    @TypeConverter
    fun fromGenreList(genres: List<GenreEnt>): String? {
        val gson = Gson()
        val type = object : TypeToken<List<GenreEnt>>() {}.getType()
        return gson.toJson(genres, type)
    }

    @TypeConverter
    fun toGenreList(genres: String): List<GenreEnt>? {
        val gson = Gson()
        val type = object : TypeToken<List<GenreEnt>>() {}.getType()
        return gson.fromJson(genres, type)
    }
}
