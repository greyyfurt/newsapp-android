package mobi.argun.newsapp_android.feature.presentation.favorites.events

import mobi.argun.newsapp_android.feature.domain.entity.Article

data class FavoritesUiState(
    val isEmpty: Boolean = false,
    val myFavoriteArticles: List<Article>? = null
)