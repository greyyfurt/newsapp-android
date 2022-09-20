package mobi.argun.newsapp_android.feature.domain.usecase

import mobi.argun.newsapp_android.feature.domain.repository.NewsRepository

class GetMyFavoritesUseCase(
    private val newsRepository: NewsRepository
) {
     operator fun invoke() =
        newsRepository.getMyFavorites()
}