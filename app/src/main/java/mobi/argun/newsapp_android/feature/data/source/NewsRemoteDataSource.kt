package mobi.argun.newsapp_android.feature.data.source

import mobi.argun.newsapp_android.feature.data.remote.services.NewsApiService
import mobi.argun.newsapp_android.feature.data.remote.util.RemoteDataSource

/**
 * @author greyyfurt
 * Created on 9.09.2022
 */
class NewsRemoteDataSource(
    private val newsApiService: NewsApiService
): RemoteDataSource() {

    suspend fun getNews(pageNum: Int) =
        performApiCall {
            newsApiService.getNews(pageNum = pageNum)
        }
}