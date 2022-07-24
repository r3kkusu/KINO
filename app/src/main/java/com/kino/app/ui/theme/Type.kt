package com.kino.app.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kino.app.R

val larsseit = FontFamily(
    listOf(
        Font(R.font.larsseit, FontWeight.Normal),
        Font(R.font.larsseit_medium, FontWeight.Medium),
        Font(R.font.larsseit_bold, FontWeight.Bold),
        Font(R.font.larsseit_thin, FontWeight.Thin),
        Font(R.font.larsseit_light, FontWeight.Light),
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        color = Color.Black,
        fontFamily = larsseit,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        color = Color.Black,
        fontFamily = larsseit,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    h1 = TextStyle(
        color = Color.Black,
        fontFamily = larsseit,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    h2 = TextStyle(
        color = Color.Black,
        fontFamily = larsseit,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    h3 = TextStyle(
        color = Color.Black,
        fontFamily = larsseit,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    h4 = TextStyle(
        color = Color.Black,
        fontFamily = larsseit,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    ),
    h5 = TextStyle(
        color = Color.Black,
        fontFamily = larsseit,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp
    ),
    h6 = TextStyle(
        color = Color.Black,
        fontFamily = larsseit,
        fontWeight = FontWeight.Bold,
        fontSize = 8.sp
    )
)