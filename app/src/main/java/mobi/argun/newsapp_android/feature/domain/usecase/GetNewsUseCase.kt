package mobi.argun.newsapp_android.feature.domain.usecase

import mobi.argun.newsapp_android.feature.domain.repository.NewsRepository
import javax.inject.Inject

class GetNewsUseCase(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(pageNum: Int) =
        newsRepository.getNews(pageNum)
}