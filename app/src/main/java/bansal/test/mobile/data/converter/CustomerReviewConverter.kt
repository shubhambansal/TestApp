package bansal.test.mobile.data.converter

import bansal.test.mobile.R
import bansal.test.mobile.data.AndroidResourceProvider
import bansal.test.mobile.data.Converter
import bansal.test.mobile.data.entity.ReviewResponse
import bansal.test.mobile.ui.reviews.CustomerReviewsViewData
import javax.inject.Inject


class CustomerReviewConverter @Inject constructor(private val androidResourceProvider: AndroidResourceProvider) : Converter<ReviewResponse, List<CustomerReviewsViewData>>() {

    override fun convert(response: ReviewResponse): List<CustomerReviewsViewData> {

        val reviewsList = arrayListOf<CustomerReviewsViewData>()

        response.data.forEach { review ->

            val submitterInfo = "${androidResourceProvider.getString(R.string.submitter_info)} ${review.reviewerName}, ${review.reviewerCountry}"
            reviewsList.add(CustomerReviewsViewData(review.title?: "", review.rating.toFloat() , review.message?: "", submitterInfo))
        }

        return reviewsList
    }
}