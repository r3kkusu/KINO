package com.kino.app.data.mapper

import com.kino.app.data.local.entities.CountryEnt
import com.kino.app.data.local.entities.EmbedUrlEnt
import com.kino.app.data.local.entities.GenreEnt
import com.kino.app.data.remote.dto.CountryDto
import com.kino.app.data.remote.dto.EmbedUrlDto
import com.kino.app.data.remote.dto.GenreDto
import com.kino.app.domain.model.Country
import com.kino.app.domain.model.EmbedUrl
import com.kino.app.domain.model.Genre

fun GenreEnt.toGenre() : Genre {
    return Genre(
        uuid = uuid,
        name = name
    )
}


fun Genre.toGenreEnt(): GenreEnt {
    return GenreEnt(
        uuid = uuid,
        name = name
    )
}

fun GenreDto.toGenre(): Genre {
    return Genre(
        uuid = uuid,
        name = name
    )
}

fun List<GenreDto>.fromGenreDtoToGenre(): List<Genre> {
    var list = mutableListOf<Genre>()
    iterator().forEach {
        list.add(it.toGenre())
    }
    return list
}

fun List<GenreEnt>.fromGenreEntToGenre(): List<Genre> {
    var list = mutableListOf<Genre>()
    iterator().forEach {
        list.add(it.toGenre())
    }
    return list
}

fun List<Genre>.fromGenreToGenreEnt(): List<GenreEnt> {
    var list = mutableListOf<GenreEnt>()
    iterator().forEach {
        list.add(it.toGenreEnt())
    }
    return list
}