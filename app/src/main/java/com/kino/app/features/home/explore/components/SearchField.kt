package com.kino.app.features.home.explore.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.kino.app.R
import com.kino.app.ui.theme.Typography

@Composable
fun SearchField(onValueChange: (text: String) -> Unit) {
    val text = remember { mutableStateOf(TextFieldValue()) }
    Box(modifier = Modifier
        .padding(top = 5.dp, bottom = 5.dp, start = 25.dp, end = 25.dp)
        .height(50.dp)) {

        OutlinedTextField(
            value = text.value,
            onValueChange = {
                text.value = it
                onValueChange(it.text)
                            },
            placeholder = {
                Text(
                    stringResource(
                        id = R.string.search),
                    style = Typography.body2)
            },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_search_24),
                        contentDescription = stringResource(id = R.string.search_movie),
                        tint = Color.Gray
                    )
                }
            },
            shape = RoundedCornerShape(30.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.Gray),
            modifier = Modifier.fillMaxWidth())

    }
}