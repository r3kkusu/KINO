package com.kino.app.domain.model

data class Country(
    var name: String,
    var uuid: String
) {
    companion object {
        fun stub() : Country {
            return Country("us", "USA")
        }
    }
}