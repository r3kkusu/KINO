package com.kino.app.features.home.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kino.app.R
import com.kino.app.features.home.detail.components.LikedButton
import com.kino.app.features.home.detail.components.MovieContent
import com.kino.app.ui.theme.Typography

@Composable
fun DetailScreen() {

    Box(modifier = Modifier.fillMaxSize()) {

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.header_movie_detail),
            maxLines = 1,
            style = Typography.h1,
            fontWeight = FontWeight.Bold,
        )

        IconButton(
            modifier = Modifier.padding(10.dp),
            onClick = { /* TODO */ },

            ) {
            Icon(
                modifier = Modifier.size(30.dp),
                painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_24),
                contentDescription = stringResource(id = R.string.search),
                tint = MaterialTheme.colors.primary
            )
        }

        Box(modifier = Modifier.fillMaxSize()) {

            MovieContent()

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LikedButton()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        DetailScreen()
    }
}
