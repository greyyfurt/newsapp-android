package mobi.argun.newsapp_android.feature.domain.repository

import kotlinx.coroutines.flow.Flow
import mobi.argun.newsapp_android.feature.domain.entity.GetNews
import mobi.argun.newsapp_android.core.util.DataResult

/**
 * @author greyyfurt
 * Created on 9.09.2022
 */
interface NewsRepository {
    fun getNews(pageNum: Int): Flow<DataResult<GetNews>>
}