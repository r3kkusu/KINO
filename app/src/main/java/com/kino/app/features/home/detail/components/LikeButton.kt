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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kino.app.ui.theme.Typography
import com.kino.app.R
import com.kino.app.domain.model.Movie

@Composable
fun LikedButton(liked: Boolean, onButtonClick: (liked: Boolean) -> Unit) {
    Column {
        IconButton(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .width(150.dp)
                .height(IntrinsicSize.Max)
                .background(MaterialTheme.colors.primary),
            onClick = { onButtonClick(!liked) },
        ) {
            Text(
                text = (
                            if (liked)
                                stringResource(id = R.string.liked)
                            else stringResource(id = R.string.like)
                        ).uppercase(),
                style = Typography.h3,
                color = Color.White,
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(15.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun LikeButtonPreview() {
    LikedButton(false) {}
}