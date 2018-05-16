package bansal.test.mobile.ui.reviews.adapter.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import bansal.test.mobile.R
import bansal.test.mobile.ui.reviews.CustomerReviewsViewData
import de.zalando.lounge.ui.recyclerview.BaseViewHolder

class ReviewViewHolder(itemView: View) : BaseViewHolder<CustomerReviewsViewData>(itemView) {

    private val titleTextView: TextView = itemView.findViewById(R.id.title_text_view)
    private val ratingBar: RatingBar = itemView.findViewById(R.id.rating_bar)
    private val messageTextView: TextView = itemView.findViewById(R.id.message_text_view)
    private val authorInfoTextView: TextView = itemView.findViewById(R.id.author_info_text_view)

    override fun bind(item: CustomerReviewsViewData) {

        titleTextView.text = item.title
        titleTextView.visibility = if(item.title.isEmpty()) View.GONE else View.VISIBLE

        ratingBar.rating = item.customerRating

        messageTextView.text = item.message
        messageTextView.visibility = if(item.message.isEmpty()) View.GONE else View.VISIBLE

        authorInfoTextView.text = item.submitterInfo

    }

    companion object {
        fun create( viewGroup: ViewGroup): ReviewViewHolder {

            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.review_item_layout, viewGroup, false)

            return ReviewViewHolder(view)
        }
    }
}