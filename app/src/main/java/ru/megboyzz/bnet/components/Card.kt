package ru.megboyzz.bnet.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import ru.megboyzz.bnet.ui.theme.H1
import ru.megboyzz.bnet.ui.theme.H2

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DrugCard(
    imageURL: String,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.size(
            width = 150.dp,
            height = 300.dp
        ),
        elevation = 10.dp,
        shape = RoundedCornerShape(8.dp),
        onClick = onClick
    ){
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            AsyncImage(
                model = imageURL,
                contentDescription = null,
                modifier = Modifier.clip(RoundedCornerShape(8.dp)).fillMaxWidth().height(100.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = title.uppercase(),
                style = H1
            )
            Text(
                text = description,
                style = H2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}