package mobi.argun.newsapp_android.di.app

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mobi.argun.newsapp_android.core.util.dispatcher.CoroutineDispatcherProvider
import mobi.argun.newsapp_android.core.util.dispatcher.DispatcherProvider
import javax.inject.Singleton

/**
 * @author greyyfurt
 * Created on 9.09.2022
 */
@Module
@InstallIn(SingletonComponent::class)
class CoroutineDispatcherModule {
    @Provides
    @Singleton
    fun provideCoroutineDispatcher(): DispatcherProvider =
        CoroutineDispatcherProvider()
}