package de.zalando.lounge.ui.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import bansal.test.mobile.core.R
import bansal.test.mobile.ui.base.BaseActivity
import bansal.test.mobile.ui.base.FragmentController
import javax.inject.Inject

abstract class BaseSingleFragmentActivity : BaseActivity(), FragmentController {

    //TODO[Dagger955]: Workaround to force Dagger to generate MembersInjector in current core module,
    // otherwise it will be generated multiple times in other modules
    //See: https://github.com/google/dagger/issues/955
    @Inject
    lateinit var context: Context

    // Current fragment instance hosted directly by activity
    private var contentFragment: Fragment? = null

    override fun getLayoutId(): Int {
        return R.layout.full_screen_activity_layout
    }

    @IdRes
    protected open fun getContainerId(): Int {
        return R.id.container_frame_layout
    }

    protected abstract fun buildContentFragment(): Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Attach fragment to activity.
        if (savedInstanceState == null) {
            setContentFragment(buildContentFragment(), false)
        }
    }

    protected fun getContentFragment(): Fragment? {
        return contentFragment
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        contentFragment?.let { outState.putString(BUNDLE_EXTRA_BASE_FRAGMENT_TAG, it.tag) }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        if (savedInstanceState.containsKey(BUNDLE_EXTRA_BASE_FRAGMENT_TAG)) {
            val baseFragmentTag = savedInstanceState.getString(BUNDLE_EXTRA_BASE_FRAGMENT_TAG)
            contentFragment = findFragmentByTag(baseFragmentTag)
        }
    }


    override fun addFragmentToRootContainer(fragment: BaseSingleContainerFragment) {
        setContentFragment(fragment, true)
    }

    private fun setContentFragment(fragment: Fragment, addToBackStack: Boolean) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragmentTag = fragment.javaClass.simpleName
        fragmentTransaction.add(getContainerId(), fragment, fragmentTag)

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragmentTag)
        }

        fragmentTransaction.commit()

        contentFragment = fragment
    }

    companion object {

        private const val BUNDLE_EXTRA_BASE_FRAGMENT_TAG = "bundle_extra_base_fragment_tag"
    }
}
