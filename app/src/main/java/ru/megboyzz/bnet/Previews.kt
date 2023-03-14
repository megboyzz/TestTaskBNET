package ru.megboyzz.bnet

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import ru.megboyzz.bnet.components.DrugCard
import ru.megboyzz.bnet.components.MainScaffold
import ru.megboyzz.bnet.screens.WhereBuyButton
import ru.megboyzz.bnet.ui.theme.grey

@Preview
@Composable
fun MainScaffoldPrev() {
    val url = "http://shans.d2.i-partner.ru/upload/drugs/%D0%A5%D0%BE%D1%80%D0%B8%D1%81%D1%82_1aee8bb7.png"
    val title = "Вредители однолетних зерновых бобовых культур"
    val description = "На зернобобовых культурах питаются разнообразные многоядные и еще всякие гадости На зернобобовых культурах питаются разнообразные многоядные и еще всякие гадости"

    var searchText by remember { mutableStateOf("") }

    MainScaffold(
        searchText = searchText,
        onSearchTextChange = {searchText = it}
    ) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(10.dp)
            //modifier = Modifier.padding(10.dp)
        ){
            items(10){
                DrugCard(imageURL = url, title = title, description = description){}
            }
        }

    }
}

@Preview
@Composable
fun DurgPrevCard() {
    val url = "https://sun9-72.userapi.com/impg/YHBDQghOtzbcjApyASIC0PTwFXG6QLltReYLFQ/luwXdzulx4k.jpg?size=133x78&quality=96&sign=94c144945c697a9ab12aef626f99f1b7&type=album"

    val title = "Вредители однолетних зерновых бобовых культур"
    val description = "На зернобобовых культурах питаются разнообразные многоядные и еще всякие гадости На зернобобовых культурах питаются разнообразные многоядные и еще всякие гадости"
    Box(
        modifier = Modifier
            .background(grey)
            .padding(horizontal = 10.dp)
            .defaultMinSize(150.dp),
    ) {

        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.defaultMinSize(150.dp)
        ){
            items(10){
                DrugCard(imageURL = url, title = title, description = description){}
            }
        }

    }
}


@Preview
@Composable
fun AsyncImagePrev() {

    val url = "http://shans.d2.i-partner.ru/upload/drugs/%D0%A5%D0%BE%D1%80%D0%B8%D1%81%D1%82_1aee8bb7.png"

    AsyncImage(
        model = url,
        contentDescription = null,
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth(),
        contentScale = ContentScale.FillHeight,
        error = R.drawable.search.AsPainter(),
    )

}

@Preview
@Composable
fun WhereBuyButtonPrev() {
    WhereBuyButton {

    }
}