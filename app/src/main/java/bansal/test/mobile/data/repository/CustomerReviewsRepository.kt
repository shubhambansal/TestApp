package bansal.test.mobile.data.repository

import bansal.test.mobile.data.converter.CustomerReviewConverter
import bansal.test.mobile.data.converter.LocalReviewConverter
import bansal.test.mobile.data.rest.CustomerReviewApi
import bansal.test.mobile.data.room.reviews.ReviewDao
import bansal.test.mobile.data.room.reviews.ReviewsDataModel
import bansal.test.mobile.ui.reviews.CustomerReviewsViewData
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class CustomerReviewsRepository @Inject constructor(private val customerReviewConverter: CustomerReviewConverter,
    private val localeReviewConverter: LocalReviewConverter,
    private val reviewDao: ReviewDao,
    private val customerReviewApi: CustomerReviewApi) {


    fun getTourReviews(cityId : String, tourId : String, filterMap : Map<String, Int>, queryMap : Map<String, String>) : Observable<List<CustomerReviewsViewData>> {

        return Observable.concat(
            getReviewsFromDb(),
            getReviewsFromApi(cityId, tourId, filterMap, queryMap)
                .onErrorResumeNext(getReviewsFromDb())
        )
    }

    private fun getReviewsFromDb() : Observable<List<CustomerReviewsViewData>>{

        return reviewDao.getOnce()
            .map(localeReviewConverter)
            .toObservable()
    }

    private fun getReviewsFromApi(cityId : String, tourId : String, filterMap : Map<String, Int>, queryMap : Map<String, String>): Observable<List<CustomerReviewsViewData>> {
        return customerReviewApi.getReviews(cityId, tourId, filterMap, queryMap)
            .map(customerReviewConverter)
            .toObservable()
            .doOnNext{
                storeReviewsInDb(it)
            }.doOnError {  }
    }


    private fun storeReviewsInDb(reviewList : List<CustomerReviewsViewData>){

        Observable.fromCallable {

            reviewList.forEach { item ->
                reviewDao.put(ReviewsDataModel(item.reviewId, item.customerRating, item.title, item.message, item.reviewerName, item.country))
            }

        }.subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe {
                Timber.d("Inserted ${reviewList.size} reviews from API in DB...")
            }

    }

}