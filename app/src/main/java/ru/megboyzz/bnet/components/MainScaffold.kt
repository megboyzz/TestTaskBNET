package ru.megboyzz.bnet.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import ru.megboyzz.bnet.AsPainter
import ru.megboyzz.bnet.R
import ru.megboyzz.bnet.SpacerWidth
import ru.megboyzz.bnet.ui.theme.borderText
import ru.megboyzz.bnet.ui.theme.main
import ru.megboyzz.bnet.ui.theme.navbar

@Composable
fun MainScaffold(
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {

            var isSearching by remember { mutableStateOf(false) }

            TopAppBar(
                title = {
                    if(isSearching)
                        SearchTextField(
                            value = searchText,
                            onValueChange = onSearchTextChange
                        )
                    else
                        Text(
                            text = "Список",
                            style = navbar
                        )
                },
                actions = {
                    IconButton(onClick = { isSearching = !isSearching }) {
                        Image(
                            painter = R.drawable.search.AsPainter(),
                            contentDescription = ""
                        )
                    }
                },
                backgroundColor = main,
            )
        }
    ) {
        it.hashCode()
        content.invoke()
    }
}

@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.padding(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            backgroundColor = Color.White,
            focusedBorderColor = borderText,
            cursorColor = Color.Black
        ),
        maxLines = 1,
    )
}