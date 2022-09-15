package mobi.argun.newsapp_android.feature.presentation.favorites

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import mobi.argun.newsapp_android.feature.presentation.util.Screen
import mobi.argun.newsapp_android.ui.common.BottomNavigationBar

@Composable
fun FavoritesScreen(
    navController: NavController
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                currentScreenId = Screen.FavoritesScreen.route,
                onItemSelected = { route ->
                    navController.navigate(route)
                }
            )
        }
    ) {

    }
}