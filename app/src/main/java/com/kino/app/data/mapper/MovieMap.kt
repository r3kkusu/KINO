package com.kino.app.data.mapper

import com.kino.app.data.local.entities.MovieEnt
import com.kino.app.data.remote.dto.MovieDto
import com.kino.app.domain.model.Movie

fun MovieEnt.toMovie() : Movie {
    return Movie(
        _id = _id,
        actors = actors,
        countries = countries.fromCountryEntToCountry(),
        createdAt = createdAt,
        description = description,
        directors = directors,
        embedUrls = embedUrls.fromEmbedUrlEntToEmbedUrl(),
        episodes = episodes,
        escritors = escritors,
        genres = genres.fromGenreEntToGenre(),
        image = image,
        index = index,
        otherTitles = otherTitles,
        rating = rating,
        release = release,
        title = title,
        titleOriginal = titleOriginal,
        updatedAt = updatedAt,
        uuid = uuid,
        year = year,
        liked = liked
    )
}


fun Movie.toMovieEnt(): MovieEnt {
    return MovieEnt(
        _id = _id,
        actors = actors,
        countries = countries.fromCountryToCountryEnt(),
        createdAt = createdAt,
        description = description,
        directors = directors,
        embedUrls = embedUrls.fromEmbedUrlToEmbedUrlEnt(),
        episodes = episodes,
        escritors = escritors,
        genres = genres.fromGenreToGenreEnt(),
        image = image,
        index = index,
        otherTitles = otherTitles,
        rating = rating,
        release = release,
        title = title,
        titleOriginal = titleOriginal,
        updatedAt = updatedAt,
        uuid = uuid,
        year = year,
        liked = liked
    )
}

fun MovieDto.toMovie(): Movie {
    return Movie(
        _id = _id,
        actors = actors,
        countries = countries.fromCountryDtoToCountry(),
        createdAt = createdAt,
        description = description,
        directors = directors,
        embedUrls = embedUrls.fromEmbedUrlDtoToEmbedUrl(),
        episodes = episodes,
        escritors = escritors,
        genres = genres.fromGenreDtoToGenre(),
        image = image,
        index = index,
        otherTitles = otherTitles,
        rating = rating,
        release = release,
        title = title,
        titleOriginal = titleOriginal,
        updatedAt = updatedAt,
        uuid = uuid,
        year = year,
        liked = false
    )
}