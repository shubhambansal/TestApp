package bansal.test.mobile.data.rest

import bansal.test.mobile.data.entity.ReviewResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface CustomerReviewApi{

    @GET("/{cityId}/{tourId}/reviews.json")
    fun getReviews(@Path("cityId") cityId : String,
                @Path("tourId") tourId: String,
                @QueryMap filterMap : Map<String, Int>,
                @QueryMap sortMap : Map<String, String>): Single<ReviewResponse>
}