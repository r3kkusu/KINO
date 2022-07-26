package com.kino.app.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kino.app.data.local.entities.CountryEnt

class CountryConverter {
    @TypeConverter
    fun fromCountryList(countries: List<CountryEnt>): String? {
        val gson = Gson()
        val type = object : TypeToken<List<CountryEnt>>() {}.getType()
        return gson.toJson(countries, type)
    }

    @TypeConverter
    fun toCountryList(countries: String): List<CountryEnt>? {
        val gson = Gson()
        val type = object : TypeToken<List<CountryEnt>>() {}.getType()
        return gson.fromJson(countries, type)
    }
}