package mobi.argun.newsapp_android.feature.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import mobi.argun.newsapp_android.core.util.*
import mobi.argun.newsapp_android.core.util.dispatcher.DispatcherProvider
import mobi.argun.newsapp_android.feature.data.source.ArticleDao
import mobi.argun.newsapp_android.feature.data.remote.model.mapper.GetNewsMapper
import mobi.argun.newsapp_android.feature.data.source.NewsRemoteDataSource
import mobi.argun.newsapp_android.feature.domain.entity.Article
import mobi.argun.newsapp_android.feature.domain.entity.GetNews
import mobi.argun.newsapp_android.feature.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val dispatcher: DispatcherProvider,
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val getNewsMapper: GetNewsMapper,
    private val dao: ArticleDao
): NewsRepository {

    override fun getNews(pageNum: Int): Flow<DataResult<GetNews>> =
        flow {
            emit(Loading)
            when (val apiResult = newsRemoteDataSource.getNews(pageNum)) {
                is Success -> {
                    if (apiResult.data == null)
                        emit(Empty)
                    else emit(Success(getNewsMapper.mapToDomainModel(apiResult.data)))
                }
                is Error -> emit(Error(apiResult.cause, apiResult.code, apiResult.errorMessage))
                else -> emit(Empty)
            }
        }.flowOn(dispatcher.io)

    override suspend fun addToFavorite(article: Article) {
        dao.insertArticle(article)
    }

    override fun getMyFavorites(): Flow<List<Article>> {
        return dao.getArticles()
    }
}