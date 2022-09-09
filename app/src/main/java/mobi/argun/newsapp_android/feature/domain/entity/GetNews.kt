package mobi.argun.newsapp_android.feature.domain.entity

data class GetNews(
    val articles: List<Article?>?,
    val status: String?,
    val totalResults: Int?
)