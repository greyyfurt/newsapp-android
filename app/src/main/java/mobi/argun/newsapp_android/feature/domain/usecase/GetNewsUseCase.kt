package mobi.argun.newsapp_android.feature.domain.usecase

import mobi.argun.newsapp_android.feature.domain.repository.NewsRepository
import javax.inject.Inject

/**
 * @author greyyfurt
 * Created on 10.09.2022
 */
class GetNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(pageNum: Int) =
        newsRepository.getNews(pageNum)
}