package com.kino.app.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kino.app.data.local.entities.EmbedUrlEnt

class EmbedUrlConverter {
    @TypeConverter
    fun fromEmbedUrlList(embedUrls: List<EmbedUrlEnt>): String? {
        val gson = Gson()
        val type = object : TypeToken<List<EmbedUrlEnt>>() {}.getType()
        return gson.toJson(embedUrls, type)
    }

    @TypeConverter
    fun toEmbedUrlList(embedUrls: String): List<EmbedUrlEnt>? {
        val gson = Gson()
        val type = object : TypeToken<List<EmbedUrlEnt>>() {}.getType()
        return gson.fromJson(embedUrls, type)
    }
}