package com.kino.app.domain.model

data class Movie(
    var _id: String,
    var actors: List<String>,
    var countries: List<Country>,
    var createdAt: String,
    var description: String,
    var directors: List<String>,
    var embedUrls: List<EmbedUrl>,
    var episodes: List<String>,
    var escritors: List<String>,
    var genres: List<Genre>,
    var image: String,
    var index: Int,
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