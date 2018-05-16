package bansal.test.mobile.ui.postreview

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import de.zalando.lounge.di.CoreComponentProvider
import de.zalando.lounge.ui.base.BaseSingleFragmentActivity

class PostReviewActivity : BaseSingleFragmentActivity() {

    override fun buildContentFragment(): Fragment {
        return PostReviewFragment.newInstance()
    }

    override fun inject(componentProvider: CoreComponentProvider) {}


    companion object {

        fun createIntent(context: Context): Intent {
            return Intent(context, PostReviewActivity::class.java)
        }
    }
}
