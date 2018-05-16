package bansal.test.mobile.ui.reviews

import bansal.test.mobile.data.repository.CustomerReviewsRepository
import io.reactivex.Observable
import javax.inject.Inject

class CustomerReviewsViewModel @Inject constructor(private val customerReviewsRepository: CustomerReviewsRepository){

    private val filterMap : MutableMap<String, Int> = mutableMapOf()
    private val queryMap : MutableMap<String, String> = mutableMapOf()

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

    fun getCustomerReviewsFor(cityId : String, tourId : String) : Observable<List<CustomerReviewsViewData>>{
        return customerReviewsRepository.getTourReviews(cityId, tourId, filterMap, queryMap)
    }
}