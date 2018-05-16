package bansal.test.mobile.data.room.reviews

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "reviews")
data class ReviewsDataModel (

    @PrimaryKey
    @ColumnInfo(name = ReviewColumns.REVIEW_ID)
    val reviewId : Long,

    @ColumnInfo(name = ReviewColumns.RATING)
    val rating : Float,

    @ColumnInfo(name = ReviewColumns.TITLE)
    val title : String,

    @ColumnInfo(name = ReviewColumns.MESSAGE)
    val message : String,

//    @ColumnInfo(name = ReviewColumns.AUTHOR)
//    val author : String,
//
//    @ColumnInfo(name = ReviewColumns.IS_FOREIGN_LANGUAGE)
//    val isForeignLanguage : Boolean,
//
//    @ColumnInfo(name = ReviewColumns.DATE)
//    val date : String,

//    @ColumnInfo(name = ReviewColumns.LANGUAGE_CODE)
//    val languageCode : String,
//
//    @ColumnInfo(name = ReviewColumns.TRAVELLER_TYPE)
//    val travellerType : String?,
//
    @ColumnInfo(name = ReviewColumns.REVIEWER_NAME)
    val reviewerName : String,

    @ColumnInfo(name = ReviewColumns.REVIEWER_COUNTRY)
    val reviewerCountry : String

)