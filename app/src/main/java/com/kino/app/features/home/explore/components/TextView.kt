package com.kino.app.features.home.explore.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kino.app.ui.theme.Typography

@Composable
fun TextView(text: String) {
    Text(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(Color.LightGray)
            .padding(start = 12.dp, top = 7.4.dp, end = 12.dp, 7.4.dp),
        text = text,
        style = Typography.body2,
    )
}

@Preview(showBackground = true)
@Composable
fun TextViewPreview() {
    TextView("Sample")
}
