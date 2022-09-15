package mobi.argun.newsapp_android.di.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mobi.argun.newsapp_android.feature.data.remote.model.mapper.GetNewsMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    @Singleton
    fun provideGetNewsMapper(): GetNewsMapper =
        GetNewsMapper()
}