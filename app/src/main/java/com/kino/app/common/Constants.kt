package com.kino.app.common

import com.kino.app.R
import com.kino.app.domain.model.NavigationRoute

class Constants {
    companion object {
        var NAVIGATION_ROUTES = hashMapOf(
            Pair("explore", NavigationRoute("Explore", "explore", R.drawable.ic_baseline_explore_24)),
            Pair("favorite", NavigationRoute("Favorite", "favorite", R.drawable.ic_baseline_favorite_24)),
            Pair("detail", NavigationRoute("Detail", "detail/{movie_id}")),
        )
    }
}