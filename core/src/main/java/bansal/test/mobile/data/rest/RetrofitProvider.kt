package bansal.test.mobile.data.rest

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitProvider(okHttpClient: OkHttpClient, moshi: Moshi) {

    private val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)

    fun <T> createService(serviceClass: Class<T>, baseUrl: String): T {
        return retrofitBuilder.baseUrl(baseUrl).build().create(serviceClass)
    }
}