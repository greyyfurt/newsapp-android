package mobi.argun.newsapp_android.feature.presentation.favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import mobi.argun.newsapp_android.feature.presentation.util.Screen
import mobi.argun.newsapp_android.feature.presentation.util.SharedViewModel
import mobi.argun.newsapp_android.ui.common.BottomNavigationBar
import mobi.argun.newsapp_android.ui.common.NewsItem
import mobi.argun.newsapp_android.ui.common.PageHeader
import mobi.argun.newsapp_android.ui.theme.Dark60
import mobi.argun.newsapp_android.ui.theme.Red100

@Composable
fun FavoritesScreen(
    navController: NavController,
    sharedVM: SharedViewModel,
    favoritesVM: FavoritesViewModel = hiltViewModel()
) {
    rememberSystemUiController().setStatusBarColor(
        Red100, darkIcons = false
    )

    /** Page State */
    val pageState = favoritesVM.state.value

    Scaffold(
        topBar = {
            PageHeader(title = "My Favorites")
        },
        bottomBar = {
            BottomNavigationBar(
                currentScreenId = Screen.FavoritesScreen.route,
                onItemSelected = { route ->
                    navController.navigate(route)
                }
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(
                    top = 16.dp,
                    bottom = 88.dp
                ),
            ) {
                pageState.myFavoriteArticles?.let {
                    items(it) { myFavoriteArticle ->
                        NewsItem(
                            article = myFavoriteArticle,
                            onItemClicked = {
                                sharedVM.addArticle(myFavoriteArticle)
                                navController.navigate(Screen.NewsDetailScreen.route)
                            }
                        )
                    }
                }
            }

            if (pageState.isEmpty) {
                Text(
                    text = "No favorite news",
                    color = Dark60,
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}