package com.kino.app.domain.usecase

import com.kino.app.domain.usecase.queries.GetLikeMovies
import com.kino.app.domain.usecase.queries.SearchMovies
import com.kino.app.domain.usecase.queries.UpdateMovie

data class FavoriteUseCase (
    val getLikeMovies: GetLikeMovies,
    val updateMovie: UpdateMovie,
    val searchMovies: SearchMovies
)