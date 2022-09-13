package mobi.argun.newsapp_android.feature.data.remote.services

import mobi.argun.newsapp_android.feature.data.remote.model.response.GetNewsDto
import mobi.argun.newsapp_android.feature.data.remote.util.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author greyyfurt
 * Created on 9.09.2022
 */
interface NewsApiService {
    @GET("v2/top-headlines")
    suspend fun getNews(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNum: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<GetNewsDto>
}