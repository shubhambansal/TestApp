package bansal.test.mobile.data.repository

import bansal.test.mobile.data.converter.CustomerReviewConverter
import bansal.test.mobile.data.entity.ReviewResponse
import bansal.test.mobile.data.rest.CustomerReviewApi
import bansal.test.mobile.data.room.reviews.ReviewDao
import bansal.test.mobile.ui.reviews.CustomerReviewsViewData
import io.reactivex.Single
import javax.inject.Inject

class CustomerReviewsRepository @Inject constructor(private val customerReviewConverter: CustomerReviewConverter,
    reviewDao: ReviewDao,
    private val customerReviewApi: CustomerReviewApi) {


    fun getReviewsFromApi(cityId : String, tourId : String, filterMap : Map<String, Int>, queryMap : Map<String, String>): Single<List<CustomerReviewsViewData>> {
        return customerReviewApi.getReviews(cityId, tourId, filterMap, queryMap)
            .map { t: ReviewResponse -> customerReviewConverter.convert(t) }
    }
}