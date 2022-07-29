package com.kino.app.features.home.favorite.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.kino.app.R
import com.kino.app.domain.model.Movie
import com.kino.app.ui.theme.Typography

@Composable
fun MovieCard(
    movie: Movie,
    onLikedButtonClick: (movie: Movie) -> Unit,
    onSelectItem: (movieId: String) -> Unit
) {

    Box(modifier = Modifier.clickable { onSelectItem(movie._id) }) {
        IconButton(
            modifier = Modifier.align(Alignment.TopEnd)
                .offset(y = (-10).dp),
            onClick = {
                movie.liked = !movie.liked
                onLikedButtonClick(movie)
            }
        ) {
            Icon(
                modifier = Modifier.align(Alignment.Center),
                painter = painterResource(
                    id = if (movie.liked)
                        R.drawable.ic_baseline_favorite_24
                    else
                        R.drawable.ic_baseline_favorite_border_24
                ),
                contentDescription = stringResource(id = R.string.like),
                tint = MaterialTheme.colors.primary
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(110.dp, 170.dp)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale  = ContentScale.Crop,
                painter = rememberAsyncImagePainter(movie.image),
                contentDescription = stringResource(id = R.string.movie_artwork)
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                modifier = Modifier.padding(start = 15.dp, end = 15.dp),
                text = movie.titleOriginal,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = Typography.h3
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
//                text = "⭐ ⭐ ⭐ ⭐ ⭐",
                text = "⭐ ${movie.rating}",
                style = Typography.h3,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieCardPreview() {
    MovieCard(Movie.stub(), {}, {})
}