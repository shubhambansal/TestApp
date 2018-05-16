package bansal.test.mobile.ui.reviews

import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import bansal.test.mobile.R
import bansal.test.mobile.di.ApplicationComponent
import bansal.test.mobile.ui.postreview.PostReviewActivity
import de.zalando.lounge.di.CoreComponentProvider
import de.zalando.lounge.ui.base.BaseSingleFragmentActivity

class ReviewsActivity : BaseSingleFragmentActivity() {

    override fun buildContentFragment(): Fragment {
        return ReviewsFragment.newInstance()
    }

    override fun inject(componentProvider: CoreComponentProvider) {
        (componentProvider.getCoreComponent() as ApplicationComponent).inject(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.action_post_review){
            startActivity(PostReviewActivity.createIntent(context))
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
