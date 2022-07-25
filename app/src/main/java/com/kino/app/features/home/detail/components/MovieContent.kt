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
import androidx.compose.ui.unit.dp
import com.kino.app.R
import com.kino.app.ui.theme.Typography

@Composable
fun MovieContent() {
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
            painter = painterResource(id = R.drawable.track_art_stub_100x100bb),
            contentDescription = stringResource(id = R.string.movie_artwork)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.stub_title),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = Typography.h2,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "2003 · Comedy · 1h 64m",
            style = Typography.body1
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "⭐ ⭐ ⭐ ⭐ ⭐",
            style = Typography.body1
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = R.string.stub_plot),
            style = Typography.body1,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(70.dp))

    }
}