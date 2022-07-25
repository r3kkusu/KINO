package com.kino.app.features.home.liked.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MovieItem() {

    Row(modifier = Modifier.fillMaxWidth()) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)) {
            MovieCard()
        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)) {
            MovieCard()
        }
    }

}
