package com.kino.app.domain.usecase

import com.kino.app.domain.usecase.queries.GetMovie
import com.kino.app.domain.usecase.queries.UpdateMovie

data class DetailsUseCase (
    val getMovie: GetMovie,
    val updateMovie: UpdateMovie,
)