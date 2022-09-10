package mobi.argun.newsapp_android.feature.presentation.news

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import mobi.argun.newsapp_android.feature.presentation.util.Screen
import mobi.argun.newsapp_android.ui.common.BottomNavigationBar

/**
 * @author greyyfurt
 * Created on 10.09.2022
 */
@Composable
fun NewsScreen(
    navController: NavController
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                currentScreenId = Screen.NewsScreen.route,
                onItemSelected = { route ->
                    navController.navigate(route)
                }
            )
        }
    ) {

    }
}