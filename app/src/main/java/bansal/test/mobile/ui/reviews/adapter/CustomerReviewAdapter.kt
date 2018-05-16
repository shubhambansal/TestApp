package bansal.test.mobile.ui.reviews.adapter

import android.view.ViewGroup
import bansal.test.mobile.ui.reviews.CustomerReviewsViewData
import bansal.test.mobile.ui.reviews.adapter.viewholder.ReviewViewHolder
import de.zalando.lounge.ui.recyclerview.BaseRecyclerViewAdapter

class CustomerReviewAdapter : BaseRecyclerViewAdapter<CustomerReviewsViewData, ReviewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        return ReviewViewHolder.create(parent)
    }
}