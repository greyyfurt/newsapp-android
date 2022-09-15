package mobi.argun.newsapp_android.feature.presentation.news.events

import mobi.argun.newsapp_android.feature.domain.entity.Article

sealed class NewsUiEvents {
    object LoadMoreNews: NewsUiEvents()
    data class AddToFavorites(val article: Article): NewsUiEvents()
}