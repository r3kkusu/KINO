package com.kino.app.features.home.explore

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
import com.kino.app.features.home.explore.components.MovieCard
import com.kino.app.features.home.explore.components.SearchField
import com.kino.app.ui.theme.Typography

@Composable
fun ExplorerScreen(
    navController: NavController? = null,
    viewModel: ExploreViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.header_explore),
            maxLines = 1,
            style = Typography.h1,
            fontWeight = FontWeight.Bold,
        )
        SearchField(onValueChange = { term -> viewModel.onEvent(ExplorerEvent.Search(term)) })

        Box(modifier = Modifier.fillMaxSize()) {
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else {
                LazyColumn {
                    items(state.movies.size) { position ->
                        val movie = state.movies[position]
                        MovieCard(
                            movie = movie,
                            onLikedButtonClick = {  liked ->
                                movie.liked = liked
                                viewModel.onEvent(ExplorerEvent.LikeMovie(movie))
                            }
                        ) {
                            navController?.navigate("${Constants.NAVIGATION_ROUTES["detail"]!!.name}/${movie._id}")
                        }
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
        ExplorerScreen()
    }
}