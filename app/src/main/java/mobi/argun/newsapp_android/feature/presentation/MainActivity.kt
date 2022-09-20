package mobi.argun.newsapp_android.feature.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import mobi.argun.newsapp_android.feature.presentation.favorites.FavoritesScreen
import mobi.argun.newsapp_android.feature.presentation.news.NewsScreen
import mobi.argun.newsapp_android.feature.presentation.newsdetail.NewsDetailScreen
import mobi.argun.newsapp_android.feature.presentation.search.SearchScreen
import mobi.argun.newsapp_android.feature.presentation.util.Screen
import mobi.argun.newsapp_android.feature.presentation.util.SharedViewModel
import mobi.argun.newsapp_android.ui.theme.NewsappandroidTheme

@AndroidEntryPoint
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
                    val sharedVM: SharedViewModel = viewModel()
                    val navController = rememberNavController()
                    
                    NavHost(
                        navController = navController,
                        startDestination = Screen.NewsScreen.route
                    ) {
                        composable(Screen.NewsScreen.route) {
                            NewsScreen(navController, sharedVM)
                        }

                        composable(Screen.NewsDetailScreen.route) {
                            NewsDetailScreen(navController, sharedVM)
                        }

                        composable(Screen.FavoritesScreen.route) {
                            FavoritesScreen(navController, sharedVM)
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