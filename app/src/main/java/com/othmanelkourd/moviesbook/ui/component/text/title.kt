package com.othmanelkourd.moviesbook.ui.component.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.othmanelkourd.moviesbook.ui.theme.subTitlePrimary
import com.othmanelkourd.moviesbook.ui.theme.subTitleSecondary
import com.othmanelkourd.moviesbook.ui.theme.titlePrimary


@Composable
fun TitlePrimary(text: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.titlePrimary
    )
}

@Composable
fun SubtitlePrimary(text: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.subTitlePrimary
    )
}

@Composable
fun SubtitleSecondary(text: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.subTitleSecondary
    )
}
