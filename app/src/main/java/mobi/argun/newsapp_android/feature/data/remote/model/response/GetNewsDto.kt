package mobi.argun.newsapp_android.feature.data.remote.model.response

data class GetNewsDto(
    val articles: List<ArticleDto>?,
    val status: String?,
    val totalResults: Int?
)