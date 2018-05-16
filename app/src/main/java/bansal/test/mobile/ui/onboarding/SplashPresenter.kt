package bansal.test.mobile.ui.onboarding

import bansal.test.mobile.ui.base.Presenter
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

private const val DELAY = 3L

class SplashPresenter
@Inject constructor() : Presenter<SplashView>() {

    private val delayObservable = Observable.interval(1, 1, TimeUnit.SECONDS)


    override fun attachView(view: SplashView) {
        super.attachView(view)

        subscribe(delayObservable.take(DELAY),
                onNext = {
                    //Show progress bar. This happens with a one second delay,
                    //so the user won't see progress bar unless the experience is REALLY slow.
                    view.enableProgress(true)
                },
                onError = {

                },
                onComplete = {

                })
    }
}
