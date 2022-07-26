package com.kino.app.data.remote.dto

data class MovieDto(
    var _id: String,
    var actors: List<String>,
    var countries: List<CountryDto>,
    var createdAt: String,
    var description: String,
    var directors: List<String>,
    var embedUrls: List<EmbedUrlDto>,
    var episodes: List<String>,
    var escritors: List<String>,
    var genres: List<GenreDto>,
    var image: String,
    var index: Int,
    var otherTitles: List<String>,
    var rating: String,
    var release: String,
    var title: String,
    var titleOriginal: String,
    var updatedAt: String,
    var uuid: String,
    var year: String
)