package com.kino.app.features.home.explore.components

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.kino.app.R
import com.kino.app.features.home.explore.components.TextView
import com.kino.app.ui.theme.Typography

@Composable
fun MovieCard() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 10.dp, top = 10.dp, end = 10.dp)) {

        IconButton(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(y = (-10).dp),
            onClick = { /* TODO */ }
        ) {
            Icon(
                modifier = Modifier.align(Alignment.Center),
                painter = painterResource(id = R.drawable.ic_baseline_favorite_border_24),
                contentDescription = stringResource(id = R.string.like),
                tint = MaterialTheme.colors.primary
            )
        }

        Row(modifier = Modifier.height(IntrinsicSize.Max)) {
            Image(
                modifier = Modifier
                    .size(110.dp, 170.dp)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale  = ContentScale.Crop,
                painter = painterResource(id = R.drawable.track_art_stub_100x100bb),
                contentDescription = stringResource(id = R.string.movie_artwork)
            )
            Column(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center
                ) {
                Text(
                    text = stringResource(id = R.string.stub_title),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = Typography.body1,
                    fontWeight = FontWeight.Bold,
                )
                
                Text(
                    text = stringResource(id = R.string.stub_genre),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = Typography.body1,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row {
                    TextView(text = stringResource(id = R.string.stub_year))
                    Spacer(modifier = Modifier.width(2.dp))
                    TextView(text = "M")
                }

                Spacer(modifier = Modifier.height(4.dp))
                TextView(text = "⏰ ${stringResource(id = R.string.stub_time)}")
                Spacer(modifier = Modifier.height(4.dp))
                TextView(text = "\uD83D\uDCB5 ${stringResource(id = R.string.stub_price)}")
            }
        }
    }
}