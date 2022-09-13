package mobi.argun.newsapp_android.feature.presentation.news.events

import mobi.argun.newsapp_android.feature.domain.entity.Article

/**
 * @author greyyfurt
 * Created on 10.09.2022
 */
data class NewsServicesState(
    val isLoading: Boolean = false,
    val isEmpty: Boolean = false,
    val errMessage: String = "",
    var articles: List<Article> = emptyList(),
    var page: Int = 1,
    val endReached: Boolean = false
)