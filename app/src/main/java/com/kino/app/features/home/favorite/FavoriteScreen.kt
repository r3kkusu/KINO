package com.kino.app.features.home.favorite

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kino.app.R
import com.kino.app.common.Constants
import com.kino.app.domain.model.Movie
import com.kino.app.features.home.explore.components.SearchField
import com.kino.app.features.home.favorite.components.MovieItem
import com.kino.app.ui.theme.Typography

@Composable
fun LikedScreen(
    navController: NavController? = null,
    viewModel: FavoriteViewModel = hiltViewModel()
) {
    val state = viewModel.state

    var dou = emptyList<Movie>().toMutableList()
    val group = emptyList<List<Movie>>().toMutableList()
    state.movies.iterator().forEach {
        dou += it
        if (dou.size == 2) {
            group += dou
            dou = emptyList<Movie>().toMutableList()
        }
    }

    if (dou.isNotEmpty())
        group += dou

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
        SearchField(onValueChange = { term -> viewModel.onEvent(FavoriteEvent.Search(term)) })

        Box(modifier = Modifier.fillMaxSize()) {
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else {
                LazyColumn {
                    items(group.size) { position ->
                        val movies = group[position]
                        MovieItem(
                            movies = movies,
                            onLikedButtonClick = {
                                viewModel.onEvent(FavoriteEvent.LikeMovie(it))
                            },
                            onSelectItem = {
                                navController?.navigate("${Constants.NAVIGATION_ROUTES["detail"]!!.name}/${it}")
                            }
                        )
                    }
                }
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