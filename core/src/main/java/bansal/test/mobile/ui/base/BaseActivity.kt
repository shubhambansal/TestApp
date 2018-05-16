package bansal.test.mobile.ui.base

import android.content.Intent
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import de.zalando.lounge.di.CoreComponentProvider

/**
 * Base Activity Class that all Activities inherit from.
 * Provides:
 * <ul>
 * <li>Dependency Injection</li>
 * <li>setContentView()</li>
 * </ul>
 */
abstract class BaseActivity : AppCompatActivity(){

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected fun initFromIntent(intent: Intent) {}

    // Child fragment classed can override this method to inject required dependencies.
    protected abstract fun inject(componentProvider: CoreComponentProvider)

    override fun onCreate(savedInstanceState: Bundle?) {

        val componentProvider = getCoreComponentProvider()
        inject(componentProvider)
        componentProvider.getCoreComponent().inject(this)


        super.onCreate(savedInstanceState)

        setContentView(getLayoutId())

        // Activity must delegate intent to child activity.
        if (intent != null) {
            initFromIntent(intent)
        }
    }

    fun <T> findFragmentByTag(tag: String): T {
        return supportFragmentManager.findFragmentByTag(tag) as T
    }


    fun getCoreComponentProvider(): CoreComponentProvider {
        return application as CoreComponentProvider
    }
}