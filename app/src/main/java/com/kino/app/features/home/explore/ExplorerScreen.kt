package com.kino.app.features.home.explore

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kino.app.R
import com.kino.app.features.home.explore.components.SearchField
import com.kino.app.ui.theme.Typography

@Composable
fun ExplorerScreen() {

    val movies = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.explore),
            maxLines = 1,
            style = Typography.h1,
            fontWeight = FontWeight.Bold,
        )
        SearchField()
        LazyColumn {
            items(movies.size) {
                MovieCard()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExplorerPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        ExplorerScreen()
    }
}