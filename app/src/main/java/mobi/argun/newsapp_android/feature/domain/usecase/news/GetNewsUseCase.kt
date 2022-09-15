package mobi.argun.newsapp_android.feature.domain.usecase.news

import mobi.argun.newsapp_android.feature.domain.repository.NewsRepository
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(pageNum: Int) =
        newsRepository.getNews(pageNum)
}