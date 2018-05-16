package bansal.test.mobile.ui.onboarding

import bansal.test.mobile.R
import bansal.test.mobile.di.ApplicationComponent
import de.zalando.lounge.di.CoreComponentProvider
import de.zalando.lounge.ui.base.BaseSingleContainerFragment
import javax.inject.Inject

class SplashFragment : BaseSingleContainerFragment(), SplashView {

    @Inject
    internal
    lateinit var presenter: SplashPresenter


    override fun layoutId() = R.layout.splash_fragment_layout

    override fun inject(componentProvider: CoreComponentProvider) {
        (componentProvider.getCoreComponent() as ApplicationComponent).inject(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detachView()
    }

    override fun enableProgress(enable: Boolean) {}

    override fun showError(message: String) {

    }

    companion object {

        fun newInstance() = SplashFragment()
    }
}
