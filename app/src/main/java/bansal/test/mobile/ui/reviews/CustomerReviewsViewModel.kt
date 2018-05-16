package bansal.test.mobile.ui.reviews

import bansal.test.mobile.data.repository.CustomerReviewsRepository
import bansal.test.mobile.ui.RxUtilProvider
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class CustomerReviewsViewModel @Inject constructor(private val customerReviewsRepository: CustomerReviewsRepository,
    private val rxUtilProvider: RxUtilProvider) {

    val loadReviewsCallback: PublishSubject<List<CustomerReviewsViewData>> = PublishSubject.create()

    private val filterMap: MutableMap<String, Int> = mutableMapOf()
    private val queryMap: MutableMap<String, String> = mutableMapOf()

    init {

        // Initializing default filter values, later these values can be changed based on user input
        filterMap.clear()
        filterMap["count"] = 25 // Default number of views
        filterMap["page"] = 0
        filterMap["rating"] = 0

        // Initializing default query values, later these values can be changed based on user input
        queryMap.clear()
        queryMap["sortBy"] = "date_of_review"
        queryMap["direction"] = "DESC"
    }

    fun getCustomerReviewsFor(cityId: String, tourId: String): Observable<List<CustomerReviewsViewData>> {
        return customerReviewsRepository.getTourReviews(cityId, tourId, filterMap, queryMap)
    }

    // Function to load more reviews asynchronously
    fun loadMoreReviews(cityId: String, tourId: String, page: Int) {
        filterMap["page"] = page

        customerReviewsRepository.getTourReviews(cityId, tourId, filterMap, queryMap)
            .compose(rxUtilProvider.getNetworkToUiObservableTransformer())
            .subscribe({
                loadReviewsCallback.onNext(it)

            }, {

            })
    }
}