package ru.megboyzz.bnet.components

import androidx.compose.foundation.Image
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import ru.megboyzz.bnet.AsPainter
import ru.megboyzz.bnet.R
import ru.megboyzz.bnet.ui.theme.main
import ru.megboyzz.bnet.ui.theme.navbar

@Composable
fun ContentScaffold(
    title: String,
    onBackClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = title,
                        style = navbar
                    )
                },
                backgroundColor = main,
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Image(
                            painter = R.drawable.arrow_back.AsPainter(),
                            contentDescription = ""
                        )
                    }
                }
            )
        }
    ) {
        it.hashCode()
        content.invoke()
    }
}