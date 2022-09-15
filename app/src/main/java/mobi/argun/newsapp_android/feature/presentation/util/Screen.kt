package mobi.argun.newsapp_android.feature.presentation.util

sealed class Screen(val route: String) {
    object NewsScreen : Screen("news_screen")
    object NewsDetailScreen : Screen("news_detail_screen")
    object FavoritesScreen : Screen("favorites_screen")
    object SearchScreen : Screen("search_screen")
}