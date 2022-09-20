package mobi.argun.newsapp_android.di.domain.usecase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mobi.argun.newsapp_android.feature.domain.repository.NewsRepository
import mobi.argun.newsapp_android.feature.domain.usecase.AddToFavoritesUseCase
import mobi.argun.newsapp_android.feature.domain.usecase.GetMyFavoritesUseCase
import mobi.argun.newsapp_android.feature.domain.usecase.GetNewsUseCase
import mobi.argun.newsapp_android.feature.domain.usecase.NewsUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainUseCase {

    @Provides
    @Singleton
    fun provideNewsUseCase(newsRepository: NewsRepository): NewsUseCases {
        return NewsUseCases(
            GetNewsUseCase(newsRepository),
            GetMyFavoritesUseCase(newsRepository),
            AddToFavoritesUseCase(newsRepository)
        )
    }
}