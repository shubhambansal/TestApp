package bansal.test.mobile.di

import android.content.Context
import bansal.test.mobile.ProtoApp
import bansal.test.mobile.data.rest.di.RestModule
import bansal.test.mobile.ui.reviews.ReviewsFragment
import dagger.BindsInstance
import dagger.Component
import de.zalando.lounge.di.CoreComponent
import de.zalando.lounge.di.CoreModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidModule::class, CoreModule::class, RestModule::class, ApplicationModule::class])
interface ApplicationComponent : CoreComponent {

    fun inject(app: ProtoApp)

    fun inject(fragment: ReviewsFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): ApplicationComponent
    }
}
