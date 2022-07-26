package com.kino.app.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kino.app.data.local.entities.GenreEnt

class StringConverter {
    @TypeConverter
    fun fromStringList(string: List<String>): String? {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.getType()
        return gson.toJson(string, type)
    }

    @TypeConverter
    fun toStringList(string: String): List<String>? {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.getType()
        return gson.fromJson(string, type)
    }
}
