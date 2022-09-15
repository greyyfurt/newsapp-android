package mobi.argun.newsapp_android.di.app

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mobi.argun.newsapp_android.core.util.dispatcher.CoroutineDispatcherProvider
import mobi.argun.newsapp_android.core.util.dispatcher.DispatcherProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CoroutineDispatcherModule {
    @Provides
    @Singleton
    fun provideCoroutineDispatcher(): DispatcherProvider =
        CoroutineDispatcherProvider()
}