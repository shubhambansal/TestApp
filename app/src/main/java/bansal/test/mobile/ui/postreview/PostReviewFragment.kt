package bansal.test.mobile.ui.postreview

import bansal.test.mobile.R
import bansal.test.mobile.di.ApplicationComponent
import de.zalando.lounge.di.CoreComponentProvider
import de.zalando.lounge.ui.base.BaseSingleContainerFragment

class PostReviewFragment : BaseSingleContainerFragment() {

    override fun layoutId(): Int? {
        return R.layout.post_review_fragment_layout
    }

    override fun inject(componentProvider: CoreComponentProvider) {
        (componentProvider.getCoreComponent() as ApplicationComponent).inject(this)
    }

    companion object {
        fun newInstance() = PostReviewFragment()
    }
}
