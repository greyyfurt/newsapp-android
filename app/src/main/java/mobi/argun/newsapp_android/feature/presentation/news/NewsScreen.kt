package mobi.argun.newsapp_android.feature.presentation.news

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import mobi.argun.newsapp_android.feature.presentation.news.events.NewsUiEvents
import mobi.argun.newsapp_android.feature.presentation.util.Screen
import mobi.argun.newsapp_android.feature.presentation.util.SharedViewModel
import mobi.argun.newsapp_android.ui.common.BottomNavigationBar
import mobi.argun.newsapp_android.ui.common.NewsItem
import mobi.argun.newsapp_android.ui.common.PageHeader
import mobi.argun.newsapp_android.ui.theme.Red100

@Composable
fun NewsScreen(
    navController: NavController,
    sharedVM: SharedViewModel,
    newsVM: NewsViewModel = hiltViewModel()
) {
    rememberSystemUiController().setStatusBarColor(
        Red100, darkIcons = false
    )

    /** Page State */
    val pageState = newsVM.state.value

    Scaffold(
        topBar = {
            PageHeader(title = "Daily News")
        },
        bottomBar = {
            BottomNavigationBar(
                currentScreenId = Screen.NewsScreen.route,
                onItemSelected = { route ->
                    navController.navigate(route)
                }
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(
                    top = 16.dp,
                    bottom = 88.dp
                ),
            ) {
                pageState.articles.let { articles ->
                    val itemCount = articles.size

                    items(itemCount) {
                        if (it >= itemCount - 1
                            && !pageState.endReached
                            && !pageState.isLoading
                        ) {
                            LaunchedEffect(key1 = true) {
                                newsVM.onEvent(NewsUiEvents.LoadMoreNews)
                            }
                        }

                        NewsItem(
                            article = articles[it],
                            onItemClicked = {
                                sharedVM.addArticle(articles[it])
                                navController.navigate(Screen.NewsDetailScreen.route)
                            }
                        )
                    }
                }
            }

            if (pageState.errMessage.isNotBlank()) {
                Text(
                    text = pageState.errMessage,
                    color = MaterialTheme.colors.error,
                    fontSize = 20.sp
                )
            }

            if (pageState.isLoading) {
                CircularProgressIndicator()
            }
        }
    }
}