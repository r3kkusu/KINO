package com.kino.app.features.home.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.kino.app.R
import com.kino.app.common.utils.AppUtils
import com.kino.app.domain.model.Movie
import com.kino.app.ui.theme.Typography

@Composable
fun MovieContent(movie: Movie) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp, top = 40.dp, end = 50.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {

        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(40.dp))
                .size(250.dp, 388.dp),
            contentScale = ContentScale.Crop,
            painter = rememberAsyncImagePainter(movie.image),
            contentDescription = stringResource(id = R.string.movie_artwork)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            textAlign = TextAlign.Center,
            text = movie.titleOriginal,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = Typography.h2,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = AppUtils.GenreListToString(movie.genres),
            style = Typography.body1
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = movie.createdAt,
            style = Typography.body1
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "⭐ ${movie.rating}",
            style = Typography.body1
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = movie.description,
            style = Typography.body1,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(70.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun MovieContentPreview() {
    MovieContent(Movie.stub())
}