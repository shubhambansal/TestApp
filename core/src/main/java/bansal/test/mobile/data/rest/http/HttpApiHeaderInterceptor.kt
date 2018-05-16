package bansal.test.mobile.data.rest.http

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

private const val KEY_CONTENT_TYPE = "Content-Type"
private const val CONTENT_TYPE_VALUE = "application/json"
private const val KEY_USER_AGENT = "User-Agent"

class HttpApiHeaderInterceptor
@Inject constructor() : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .header(KEY_CONTENT_TYPE, CONTENT_TYPE_VALUE)
            .header(KEY_USER_AGENT, "Android")
            .build()

        return chain.proceed(newRequest)
    }
}
