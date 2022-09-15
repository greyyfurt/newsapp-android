package mobi.argun.newsapp_android.di.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mobi.argun.newsapp_android.feature.data.remote.services.NewsApiService
import mobi.argun.newsapp_android.feature.data.remote.util.BASE_URL
import mobi.argun.newsapp_android.feature.data.remote.util.CONNECT_TIMEOUT_IN_MILLISECONDS
import mobi.argun.newsapp_android.feature.data.remote.util.READ_TIMEOUT_IN_MILLISECONDS
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }


    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        with(OkHttpClient.Builder()) {
            connectTimeout(CONNECT_TIMEOUT_IN_MILLISECONDS, TimeUnit.MILLISECONDS)
            readTimeout(READ_TIMEOUT_IN_MILLISECONDS, TimeUnit.MILLISECONDS)
            addInterceptor(httpLoggingInterceptor)
            addNetworkInterceptor(StethoInterceptor())
            build()
        }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideNewsApiService(retrofit: Retrofit): NewsApiService =
        retrofit.create(NewsApiService::class.java)
}