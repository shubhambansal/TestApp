package bansal.test.mobile.data.entity

data class Reviews (
    var review_id : Long,
    var rating: String,
    var title : String?,
    var message : String?,
    var author : String,
    var foreignLanguage : Boolean,
    var date : String,
    var languageCode : String,
    var traveler_type : String?,
    var reviewerName : String?,
    var reviewerCountry : String
)