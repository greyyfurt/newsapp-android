package mobi.argun.newsapp_android.feature.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mobi.argun.newsapp_android.feature.presentation.favorites.FavoritesScreen
import mobi.argun.newsapp_android.feature.presentation.news.NewsScreen
import mobi.argun.newsapp_android.feature.presentation.search.SearchScreen
import mobi.argun.newsapp_android.feature.presentation.util.Screen
import mobi.argun.newsapp_android.ui.theme.NewsappandroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsappandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    
                    NavHost(
                        navController = navController,
                        startDestination = Screen.NewsScreen.route
                    ) {
                        composable(Screen.NewsScreen.route) {
                            NewsScreen(navController = navController)
                        }

                        composable(Screen.FavoritesScreen.route) {
                            FavoritesScreen(navController = navController)
                        }

                        composable(Screen.SearchScreen.route) {
                            SearchScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}