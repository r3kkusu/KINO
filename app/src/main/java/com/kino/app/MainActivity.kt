package com.kino.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kino.app.features.KINOApp
import com.kino.app.ui.theme.KINOTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KINOTheme {
                KINOApp()
            }
        }
    }
}

@Composable
fun test() {
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KINOTheme {
        KINOApp()
    }
}