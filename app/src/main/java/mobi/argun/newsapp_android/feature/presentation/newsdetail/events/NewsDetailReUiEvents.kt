package mobi.argun.newsapp_android.feature.presentation.newsdetail.events

sealed class NewsDetailReUiEvents {
    data class ShowSnackBar(val message: String): NewsDetailReUiEvents()
}