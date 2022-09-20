package mobi.argun.newsapp_android.feature.presentation.newsdetail.events

import mobi.argun.newsapp_android.feature.domain.entity.Article

sealed class NewsDetailUiEvents {
    data class AddToFavorites(val article: Article): NewsDetailUiEvents()
}