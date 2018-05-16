package bansal.test.mobile.data.rest.di

import bansal.test.mobile.data.rest.RetrofitProvider
import bansal.test.mobile.data.rest.http.HttpApiHeaderInterceptor
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class RestModule {

    @Provides
    @Singleton
    fun provideRetrofitProvider(okHttpClient: OkHttpClient, moshi: Moshi): RetrofitProvider {
        return RetrofitProvider(okHttpClient, moshi)
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
                .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpApiHeaderInterceptor: HttpApiHeaderInterceptor): OkHttpClient {

        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor(httpApiHeaderInterceptor)
        return okHttpClient.build()
    }
}
