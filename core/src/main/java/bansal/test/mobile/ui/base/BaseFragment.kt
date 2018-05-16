package bansal.test.mobile.ui.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hannesdorfmann.fragmentargs.FragmentArgs
import de.zalando.lounge.di.CoreComponentProvider
import timber.log.Timber

private const val TAG_LIFECYCLE = "lifecycle"

abstract class BaseFragment : Fragment() {

    @LayoutRes
    protected abstract fun layoutId(): Int?

    // Child fragment classed can override this method to inject required dependencies.
    protected abstract fun inject(componentProvider: CoreComponentProvider)

    override fun onCreate(savedInstanceState: Bundle?) {

        FragmentArgs.inject(this) // read @Arg fields

        val componentProvider = (activity as BaseActivity).getCoreComponentProvider()
        inject(componentProvider)
        componentProvider.getCoreComponent().inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Timber.tag(TAG_LIFECYCLE).i("Fragment onCreateView: %s", javaClass.simpleName)

        return layoutId()?.let {
            inflater.inflate(it, container, false)
        } ?: super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroyView() {
        Timber.tag(TAG_LIFECYCLE).i("Fragment onDestroyView: %s", javaClass.simpleName)
        super.onDestroyView()
    }
}
