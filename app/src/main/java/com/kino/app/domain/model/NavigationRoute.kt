package com.kino.app.domain.model

import com.kino.app.R
import com.kino.app.common.Constants

data class NavigationRoute(
    val name: String,
    val route: String,
    val resource: Int
) {
    companion object {
        fun screens() : List<NavigationRoute> = listOf(
            Constants.NAVIGATION_ROUTES["explore"]!!,
            Constants.NAVIGATION_ROUTES["favorite"]!!
        )
    }
}