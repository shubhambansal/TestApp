package bansal.test.mobile.di

import bansal.test.mobile.data.rest.RetrofitProvider
import bansal.test.mobile.data.rest.CustomerReviewApi
import bansal.test.mobile.data.room.ProtoAppDatabase
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun provideCustomerReviewsApi(retrofitProvider: RetrofitProvider) : CustomerReviewApi{
        return retrofitProvider.createService(CustomerReviewApi::class.java, "https://www.getyourguide.com/")
    }

    @Provides
    fun providesCustomerReviewsDao(protoAppDatabase: ProtoAppDatabase) = protoAppDatabase.reviewDao()
}