package com.kino.app.features.home.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kino.app.ui.theme.Typography

@Composable
fun LikedButton() {
    Column {
        IconButton(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .width(150.dp)
                .height(IntrinsicSize.Max)
                .background(MaterialTheme.colors.primary),
            onClick = { /*TODO*/ },
        ) {
            Text(
                text = "LIKE",
                style = Typography.h3,
                color = Color.White,
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(15.dp))
    }
}