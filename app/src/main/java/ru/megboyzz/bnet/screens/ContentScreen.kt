package ru.megboyzz.bnet.screens

import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import ru.megboyzz.bnet.AsPainter
import ru.megboyzz.bnet.MainViewModel
import ru.megboyzz.bnet.R
import ru.megboyzz.bnet.components.ContentScaffold
import ru.megboyzz.bnet.navigation.AppNavRoute
import ru.megboyzz.bnet.ui.theme.H1
import ru.megboyzz.bnet.ui.theme.H2

@Composable
fun ContentScreen(viewModel: MainViewModel, navHostController: NavHostController) {

    val activeDrug = viewModel.getActiveDrug()

    if(activeDrug != null)
    ContentScaffold(
        title = activeDrug.name,
        onBackClick = { navHostController.navigate(AppNavRoute.Main.route) }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(
                horizontal = 15.dp,
                vertical = 20.dp
            )
        ) {
            Box(
                modifier = Modifier.padding(horizontal = 10.dp)
            ){
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ){
                    IconButton(onClick = { }) {
                        Image(
                            painter = R.drawable.star.AsPainter(),
                            contentDescription = ""
                        )
                    }
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth()
                ){
                    AsyncImage(
                        model = "${viewModel.baseURL}${activeDrug.image}",
                        contentDescription = null,
                        modifier = Modifier.height(300.dp)
                    )
                }
            }
            Text(
                text = activeDrug.name,
                style = H1,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = activeDrug.description,
                style = H2,
                modifier = Modifier.fillMaxWidth()
            )
            WhereBuyButton {

            }
        }
    }

}

@Composable
fun WhereBuyButton(
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ){
            Image(
                painter = R.drawable.map.AsPainter(),
                contentDescription = ""
            )
            Text(
                text = "Где купить?",
                style = H1
            )
        }
    }
}