package bansal.test.mobile.ui.reviews

import android.support.v4.app.Fragment
import de.zalando.lounge.di.CoreComponentProvider
import de.zalando.lounge.ui.base.BaseSingleFragmentActivity

class ReviewsActivity : BaseSingleFragmentActivity() {

    override fun buildContentFragment(): Fragment {
        return ReviewsFragment.newInstance()
    }

    override fun inject(componentProvider: CoreComponentProvider) {}
}
