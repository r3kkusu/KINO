package com.kino.app.features.home.liked.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.kino.app.R
import com.kino.app.ui.theme.Typography

@Composable
fun MovieCard() {
    Box {
        IconButton(
            modifier = Modifier.align(Alignment.TopEnd)
                .offset(y = (-10).dp),
            onClick = { /* TODO */ }
        ) {
            Icon(
                modifier = Modifier.align(Alignment.Center),
                painter = painterResource(id = R.drawable.ic_baseline_favorite_24),
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
                painter = painterResource(id = R.drawable.track_art_stub_100x100bb),
                contentDescription = stringResource(id = R.string.movie_artwork)
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                modifier = Modifier.padding(start = 15.dp, end = 15.dp),
                text = stringResource(id = R.string.stub_title),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = Typography.h3
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "⭐ ⭐ ⭐ ⭐ ⭐",
                style = Typography.h3,
            )
        }
    }
}