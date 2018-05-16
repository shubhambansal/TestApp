package bansal.test.mobile

import android.app.Application
import android.os.StrictMode
import bansal.test.mobile.di.ApplicationComponent
import bansal.test.mobile.di.DaggerApplicationComponent
import com.squareup.leakcanary.LeakCanary
import de.zalando.lounge.di.ComponentBuilder
import de.zalando.lounge.di.CoreComponent
import de.zalando.lounge.di.CoreComponentProvider

class ProtoApp : Application(), CoreComponentProvider {

    private lateinit var applicationComponent : ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {

            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
                .detectNetwork()
                .penaltyLog()
                .build())

            StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .penaltyLog()
                .build())

        }

        initDependencyInjection()

        // Memory Leaks
        LeakCanary.install(this)
    }


    private fun initDependencyInjection() {

        applicationComponent = DaggerApplicationComponent.builder()
            .context(this)
            .build()
        applicationComponent.inject(this)
    }

    override fun <T> getComponent(componentType: Class<T>, componentBuilder: ComponentBuilder<T>): T {
        return componentBuilder.buildComponent()
    }

    override fun getCoreComponent(): CoreComponent {
        return applicationComponent;
    }
}