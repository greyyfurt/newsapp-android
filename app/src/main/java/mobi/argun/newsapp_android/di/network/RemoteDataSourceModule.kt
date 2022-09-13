package mobi.argun.newsapp_android.di.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mobi.argun.newsapp_android.feature.data.remote.services.NewsApiService
import mobi.argun.newsapp_android.feature.data.source.NewsRemoteDataSource
import javax.inject.Singleton

/**
 * @author greyyfurt
 * Created on 9.09.2022
 */
@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {

    @Provides
    @Singleton
    fun provideNewsRemoteDataSource(
        newsApiService: NewsApiService
    ): NewsRemoteDataSource =
        NewsRemoteDataSource(newsApiService)
}