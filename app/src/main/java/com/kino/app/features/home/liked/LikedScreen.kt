package com.kino.app.features.home.liked

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kino.app.R
import com.kino.app.features.home.explore.components.SearchField
import com.kino.app.features.home.liked.components.MovieItem
import com.kino.app.ui.theme.Typography

@Composable
fun LikedScreen() {

    val movies = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.header_liked),
            maxLines = 1,
            style = Typography.h1,
            fontWeight = FontWeight.Bold,
        )
        SearchField(onValueChange = {

        })
        LazyColumn {
            items(movies.size) {
                MovieItem()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExplorerPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        LikedScreen()
    }
}