package com.kino.app.features.home.favorite.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kino.app.domain.model.Movie

@Composable
fun MovieItem(
        movies: List<Movie>,
        onLikedButtonClick: (movie: Movie) -> Unit,
        onSelectItem: (movieId: String) -> Unit
    ) {

    Row(modifier = Modifier.fillMaxWidth()) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
        ) {
            MovieCard(movies[0], onLikedButtonClick, onSelectItem)
        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)) {
            if (movies.size == 2) {
                MovieCard(movies[1], onLikedButtonClick, onSelectItem)
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun MovieItemPreview() {
    MovieItem(listOf(Movie.stub()), {}, {})
}