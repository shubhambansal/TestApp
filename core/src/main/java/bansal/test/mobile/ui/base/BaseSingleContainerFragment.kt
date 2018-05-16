package de.zalando.lounge.ui.base

import android.content.Context
import bansal.test.mobile.ui.base.BaseFragment
import bansal.test.mobile.ui.base.FragmentController

import javax.inject.Inject

/**
 * A fragment that will add its fragment to the fragment container of [BaseSingleFragmentActivity],
 * using [.addFragment]
 */
abstract class BaseSingleContainerFragment : BaseFragment() {

    //TODO[Dagger955]
    @Inject
    internal lateinit var context: Context

    private lateinit var fragmentController: FragmentController

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is FragmentController) {
            fragmentController = context
        } else {
            throw ClassCastException(context.javaClass.simpleName + " doesn't implement FragmentController!")
        }
    }

    protected fun addFragment(fragment: BaseSingleContainerFragment) {
        fragmentController.addFragmentToRootContainer(fragment)
    }

}
