package bansal.test.mobile.ui.reviews

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bansal.test.mobile.R
import bansal.test.mobile.di.ApplicationComponent
import bansal.test.mobile.ui.RxUtilProvider
import bansal.test.mobile.ui.reviews.adapter.CustomerReviewAdapter
import de.zalando.lounge.di.CoreComponentProvider
import de.zalando.lounge.ui.base.BaseSingleContainerFragment
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class ReviewsFragment : BaseSingleContainerFragment() {

    private lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var customerReviewsViewModel : CustomerReviewsViewModel

    @Inject
    lateinit var rxUtilProvider : RxUtilProvider

    private val compositeSubscription = CompositeDisposable()
    private lateinit var adapter : CustomerReviewAdapter

    // These api params can be generic based on tour and city and later can be passed as a part of fragment args.
    private val cityId : String = "berlin-l17"
    private val tourId : String = "tempelhof-2-hour-airport-history-tour-berlin-airlift-more-t23776"


    override fun layoutId() = R.layout.review_fragment_layout

    override fun inject(componentProvider: CoreComponentProvider) {
        (componentProvider.getCoreComponent() as ApplicationComponent).inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        return view!!.apply {
            recyclerView = findViewById(R.id.recyclerView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        subscribe(customerReviewsViewModel.getCustomerReviewsFor(cityId, tourId), onSuccess = {
            reviewList -> adapter.items = reviewList

        }, onError = {
            //TODO Show error notification to end user.

        })
    }

    private fun initRecyclerView() {

        adapter = CustomerReviewAdapter()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    // Generic method to handle subscribers
    private fun <ReturnType> subscribe(
        observable: Single<ReturnType>,
        onSuccess: (ReturnType) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        compositeSubscription.add(observable
            .compose(rxUtilProvider.getNetworkToUiSingleTransformer<ReturnType>())
            .subscribe(onSuccess, onError))
    }


    override fun onDestroyView() {
        super.onDestroyView()
        cancel()
    }

    private fun cancel() {

        if (!compositeSubscription.isDisposed) {
            Timber.d("Cancelling Subscription For: %s", javaClass.name)
            compositeSubscription.clear()
        }
    }

    companion object {
        fun newInstance() = ReviewsFragment()
    }
}
