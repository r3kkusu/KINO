package com.kino.app.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.kino.app.data.local.converters.CountryConverter
import com.kino.app.data.local.converters.EmbedUrlConverter
import com.kino.app.data.local.converters.GenreConverter
import com.kino.app.data.local.converters.StringConverter

@Entity(tableName = "movie_table")
data class MovieEnt(
    @PrimaryKey var _id: String,

    @TypeConverters(StringConverter::class)
    var actors: List<String>,

    @TypeConverters(CountryConverter::class)
    var countries: List<CountryEnt>,

    var createdAt: String,

    var description: String,

    @TypeConverters(StringConverter::class)
    var directors: List<String>,

    @TypeConverters(EmbedUrlConverter::class)
    var embedUrls: List<EmbedUrlEnt>,

    @TypeConverters(StringConverter::class)
    var episodes: List<String>,

    @TypeConverters(StringConverter::class)
    var escritors: List<String>,

    @TypeConverters(GenreConverter::class)
    var genres: List<GenreEnt>,

    var image: String,

    var index: Int,

    @TypeConverters(StringConverter::class)
    var otherTitles: List<String>,

    var rating: String,

    var release: String,

    var title: String,

    var titleOriginal: String,

    var updatedAt: String,

    var uuid: String,

    var year: String,

    var liked: Boolean
)