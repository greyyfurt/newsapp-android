package mobi.argun.newsapp_android.feature.presentation.util

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import mobi.argun.newsapp_android.feature.domain.entity.Article

class SharedViewModel : ViewModel() {

    var article by mutableStateOf<Article?>(null)
        private set

    fun addArticle(newArticle: Article) {
        article = newArticle
    }
}