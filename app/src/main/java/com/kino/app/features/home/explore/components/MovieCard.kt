package com.kino.app.features.home.explore.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.kino.app.R
import com.kino.app.common.utils.AppUtils
import com.kino.app.domain.model.Movie
import com.kino.app.features.home.explore.ExplorerScreen
import com.kino.app.ui.theme.Typography

@Composable
fun MovieCard(
    movie: Movie,
    onLikedButtonClick: (liked: Boolean) -> Unit,
    onSelect: () -> Unit
    ) {

    var isLiked by remember { mutableStateOf(movie.liked) }

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 10.dp, top = 5.dp, end = 10.dp, bottom = 5.dp)
        .clickable { onSelect() },
    ) {

        IconButton(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(y = (-10).dp),
            onClick = {
                isLiked = !movie.liked
                onLikedButtonClick(isLiked)
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

        Row(modifier = Modifier
            .height(IntrinsicSize.Max)
            .padding(end = 40.dp)) {
            Image(
                modifier = Modifier
                    .size(110.dp, 170.dp)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale  = ContentScale.Crop,
                painter = rememberAsyncImagePainter(movie.image),
                contentDescription = stringResource(id = R.string.movie_artwork)
            )
            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center
                ) {
                Text(
                    text = movie.titleOriginal,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = Typography.body1,
                    fontWeight = FontWeight.Bold,
                )
                
                Text(
                    text = AppUtils.GenreListToString(movie.genres),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = Typography.body1,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row {
                    TextView(text = movie.year)
                    Spacer(modifier = Modifier.width(2.dp))
                    TextView(text = "⭐ ${movie.rating}")
                }

                Spacer(modifier = Modifier.height(4.dp))
                TextView(text = "⏰ ${/*DateUtils.format(movie.trackTimeMillis!!.toLong(), DateUtils.DATE_FORMAT_5) ?:*/ stringResource(id = R.string.stub_data)}")
                Spacer(modifier = Modifier.height(4.dp))
                TextView(text = "\uD83D\uDCB5 ${/*movie.trackPrice ?:*/ stringResource(id = R.string.stub_data)} US")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieCardPreview() {
    MovieCard(Movie.stub(), {}) {}
}
