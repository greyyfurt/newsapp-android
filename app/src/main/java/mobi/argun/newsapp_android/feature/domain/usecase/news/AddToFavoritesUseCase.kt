package mobi.argun.newsapp_android.feature.domain.usecase.news

import mobi.argun.newsapp_android.feature.domain.entity.Article
import mobi.argun.newsapp_android.feature.domain.repository.NewsRepository
import javax.inject.Inject

class AddToFavoritesUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(article: Article) {
        newsRepository.addToFavorite(article)
    }
}