package mobi.argun.newsapp_android.ui.common.util

import androidx.annotation.DrawableRes
import mobi.argun.newsapp_android.R
import mobi.argun.newsapp_android.feature.presentation.util.Screen

sealed class BottomNavItem(
    val route: String,
    val name: String,
    @DrawableRes val icon: Int,
) {
    object News : BottomNavItem(
        route = Screen.NewsScreen.route,
        name = "News",
        icon = R.drawable.ic_launcher_foreground
    )
    object Favorites : BottomNavItem(
        route = Screen.FavoritesScreen.route,
        name = "Favorites",
        icon = R.drawable.ic_launcher_foreground
    )
    object Search : BottomNavItem(
        route = Screen.SearchScreen.route,
        name = "Search",
        icon = R.drawable.ic_launcher_foreground
    )
}