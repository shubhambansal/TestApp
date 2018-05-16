package bansal.test.mobile.ui.base

import de.zalando.lounge.ui.base.BaseSingleContainerFragment

interface FragmentController {

    /**
     * Add passed fragment on top of fragment stack.
     *
     * @param fragment
     */
    fun addFragmentToRootContainer(fragment: BaseSingleContainerFragment)
}
