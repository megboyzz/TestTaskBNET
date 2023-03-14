package ru.megboyzz.bnet.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.megboyzz.bnet.MainViewModel
import ru.megboyzz.bnet.components.DrugCard
import ru.megboyzz.bnet.components.MainScaffold
import ru.megboyzz.bnet.navigation.AppNavRoute

@Composable
fun MainScreen(viewModel: MainViewModel, navHostController: NavHostController) {

    var searchText by remember { mutableStateOf("") }

    val drugs by viewModel.drugs.collectAsState()

    MainScaffold(
        searchText = searchText,
        onSearchTextChange = {
            searchText = it
            viewModel.searchDrugs(searchText)
        }
    ) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            contentPadding = PaddingValues(15.dp)
        ){
            items(drugs){
                DrugCard(
                    imageURL = "${viewModel.baseURL}${it.image}",
                    title = it.name,
                    description = it.description
                ){
                    viewModel.setActiveDrug(it)
                    navHostController.navigate(AppNavRoute.Content.route)
                }
            }
        }
    }
}