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
) {
    companion object {
        fun stub() : Movie {
            return Movie(
                "61e8a4c5f2eb8ced20633f4f",
                listOf("Will Smith"),
                listOf(Country.stub()),
                "2022-01-19T23:54:45.509Z",
                "A menos de dos semanas de casarse con Gretchen (Kaley Cuoco), la chica de sus sueños, Doug Harris (Josh Gad) no encuentra siquiera a un conocido que pueda hacer de padrino en su boda, por lo que termina contratando a Jimmy Callahan (Kevin Hart), propietario de una empresa que provee de falsos padrinos a novios solitarios como él.\n.",
                listOf("Adam Savage"),
                listOf(EmbedUrl.stub()),
                listOf("episode 1"),
                emptyList(),
                listOf(Genre.stub()),
                "https://image.tmdb.org/t/p/w300/c0p6YAhrl5tLNqXydVUotJiEufR.jpg",
                40,
                emptyList(),
                "6.4/10",
                "16 Jan 2015",
                "El gurú de las bodas",
                "The Wedding Ringer",
                "2022-06-28T19:34:59.870Z",
                "el-guru-de-las-bodas",
                "2015",
                false
            )
        }
    }
}