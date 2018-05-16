package bansal.test.mobile.ui.onboarding

import android.support.v4.app.Fragment
import de.zalando.lounge.di.CoreComponentProvider
import de.zalando.lounge.ui.base.BaseSingleFragmentActivity

class SplashActivity : BaseSingleFragmentActivity() {

    override fun buildContentFragment(): Fragment {
        return SplashFragment.newInstance()
    }

    override fun inject(componentProvider: CoreComponentProvider) {}
}
