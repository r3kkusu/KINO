package com.kino.app.features

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kino.app.domain.model.NavigationRoute
import com.kino.app.features.home.explore.ExplorerScreen
import com.kino.app.features.home.navigation.NavigationControl

@Composable
fun KINOApp() {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        NavigationControl(navItems = NavigationRoute.screens())
    }
}

@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        ExplorerScreen()
    }
}