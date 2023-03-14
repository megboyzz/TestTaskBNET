package ru.megboyzz.bnet.navigation


import android.app.Activity
import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.megboyzz.bnet.MainViewModel
import ru.megboyzz.bnet.MainViewModelFactory
import ru.megboyzz.bnet.screens.ContentScreen
import ru.megboyzz.bnet.screens.MainScreen


sealed class AppNavRoute(val route: String){
    object Main : AppNavRoute("main_screen")
    object Content: AppNavRoute("content_screen")
}

@Composable
fun AppNavHost(){

    val activity = LocalContext.current as Activity

    val viewModel: MainViewModel = viewModel(factory = MainViewModelFactory(activity.application))

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppNavRoute.Main.route
    ){
        composable(AppNavRoute.Main.route)    { MainScreen(viewModel, navController) }
        composable(AppNavRoute.Content.route) { ContentScreen(viewModel, navController) }
    }
}