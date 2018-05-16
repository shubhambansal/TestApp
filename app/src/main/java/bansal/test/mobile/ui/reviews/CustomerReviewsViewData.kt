package bansal.test.mobile.ui.reviews

data class CustomerReviewsViewData(var reviewId : Long, var title: String,
    var customerRating: Float,
    var message: String,
    var reviewerName: String,
    var country : String,
    var submitterInfo : String)