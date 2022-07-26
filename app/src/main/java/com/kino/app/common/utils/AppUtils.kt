package com.kino.app.common.utils

import com.kino.app.domain.model.Genre

class AppUtils {
    companion object {
        fun GenreListToString(genres: List<Genre>) : String {
            var gerne = ""
            genres.forEachIndexed { i, elem ->
                gerne += "${elem.name} ${if (i < genres.size) "," else ""}"
            }
            return gerne
        }
    }
}