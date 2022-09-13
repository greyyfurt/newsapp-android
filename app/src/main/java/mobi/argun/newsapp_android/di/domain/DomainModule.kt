package mobi.argun.newsapp_android.di.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mobi.argun.newsapp_android.core.util.dispatcher.DispatcherProvider
import mobi.argun.newsapp_android.feature.data.remote.model.mapper.GetNewsMapper
import mobi.argun.newsapp_android.feature.data.repository.NewsRepositoryImpl
import mobi.argun.newsapp_android.feature.data.source.NewsRemoteDataSource
import mobi.argun.newsapp_android.feature.data.source.ArticleDatabase
import mobi.argun.newsapp_android.feature.domain.repository.NewsRepository
import javax.inject.Singleton

/**
 * @author greyyfurt
 * Created on 9.09.2022
 */
@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideNewsRepository(
        dispatcherProvider: DispatcherProvider,
        newsRemoteDataSource: NewsRemoteDataSource,
        getNewsMapper: GetNewsMapper,
        db: ArticleDatabase,
    ): NewsRepository =
        NewsRepositoryImpl(
            dispatcherProvider,
            newsRemoteDataSource,
            getNewsMapper,
            db.articleDao
        )
}