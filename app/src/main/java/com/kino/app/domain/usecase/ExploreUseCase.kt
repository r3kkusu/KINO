package com.kino.app.domain.usecase

import com.kino.app.domain.usecase.queries.GetMovies
import com.kino.app.domain.usecase.queries.UpdateMovie

data class ExploreUseCase (
    val getMovies: GetMovies,
    val updateMovie: UpdateMovie
)