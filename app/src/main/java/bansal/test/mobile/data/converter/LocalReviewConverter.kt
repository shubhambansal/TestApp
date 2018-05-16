package bansal.test.mobile.data.converter

import bansal.test.mobile.R
import bansal.test.mobile.data.AndroidResourceProvider
import bansal.test.mobile.data.Converter
import bansal.test.mobile.data.room.reviews.ReviewsDataModel
import bansal.test.mobile.ui.reviews.CustomerReviewsViewData
import javax.inject.Inject

//TODO this class is bit redundant class, need to refactor data model part a bit.
class LocalReviewConverter @Inject constructor(private val androidResourceProvider: AndroidResourceProvider) : Converter<List<ReviewsDataModel>, List<CustomerReviewsViewData>>() {

    override fun convert(localReviewList: List<ReviewsDataModel>): List<CustomerReviewsViewData> {

        val reviewsList = arrayListOf<CustomerReviewsViewData>()

        localReviewList.forEach { review ->

            val submitterInfo = "${androidResourceProvider.getString(R.string.submitter_info)} ${review.reviewerName}, ${review.reviewerCountry}"
            reviewsList.add(CustomerReviewsViewData(review.reviewId,review.title,
                review.rating,
                review.message,
                review.reviewerName,
                review.reviewerCountry,
                submitterInfo))
        }

        return reviewsList
    }
}