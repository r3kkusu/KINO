package com.kino.app.features.home.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kino.app.common.Constants
import com.kino.app.domain.model.NavigationRoute
import com.kino.app.features.home.explore.ExplorerScreen
import com.kino.app.features.home.favorite.LikedScreen
import com.kino.app.ui.theme.Purple200


@Composable
fun NavigationControl(navItems: List<NavigationRoute>) {
    val navController = rememberNavController()
    Scaffold(bottomBar = {
        BottomNavigationBar(
            items = navItems,
            navigationController = navController,
            modifier = Modifier,
            onItemClick = {
                navController.navigate(it.route)
            }
        )
    }) {
        Box(modifier = Modifier
            .fillMaxSize()) {
            Navigation(navController = navController)
        }

    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Constants.NAVIGATION_ROUTES["explore"]!!.route ) {
        composable(Constants.NAVIGATION_ROUTES["explore"]!!.route) { ExplorerScreen() }
        composable(Constants.NAVIGATION_ROUTES["favorite"]!!.route) { LikedScreen() }
    }
}

@Composable
fun BottomNavigationBar(
    items: List<NavigationRoute>,
    navigationController: NavHostController,
    modifier: Modifier,
    onItemClick: (NavigationRoute) -> Unit
) {
    val backStackEntry = navigationController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.Black,
        elevation = 5.dp
    ) {
        items.forEach {
            val selected = it.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(it) },
                selectedContentColor = Purple200,
                unselectedContentColor = Color.White,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(painter = painterResource(id = it.resource), contentDescription = it.name)
                        Spacer(modifier = Modifier.height(6.dp))
                        Box(
                            modifier = Modifier
                                .size(3.dp)
                                .clip(CircleShape)
                                .background(if (selected) Purple200 else Color.White)
                        )
                    }
                }
            )
        }
    }
}
