package mobi.argun.newsapp_android.feature.domain.usecase.news

import mobi.argun.newsapp_android.feature.domain.entity.Article
import mobi.argun.newsapp_android.feature.domain.repository.NewsRepository

/**
 * @author greyyfurt
 * Created on 13.09.2022
 */
class AddToFavoritesUseCase(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(article: Article) {
        newsRepository.addToFavorite(article)
    }
}