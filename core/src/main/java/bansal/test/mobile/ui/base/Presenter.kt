package bansal.test.mobile.ui.base

import android.support.annotation.CallSuper
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import bansal.test.mobile.data.AndroidResourceProvider
import bansal.test.mobile.ui.RxUtilProvider
import timber.log.Timber
import javax.inject.Inject

/**
 * Base Presenter, mainly handling:
 *
 *  * Handling UI observables, and cancelling their subscriptions.
 *
 * @param <ViewType>
</ViewType> */
abstract class Presenter<ViewType> {

    @Inject
    internal lateinit var rxUtilProvider: RxUtilProvider

    @Inject
    lateinit var resourceProvider: AndroidResourceProvider

    @JvmField
    var view: ViewType? = null

    private val compositeSubscription = CompositeDisposable()


    @CallSuper
    open fun attachView(view: ViewType) {
        this.view = view
    }

    @CallSuper
    open fun detachView() {
        cancel()
        view = null
    }

    protected fun <ReturnType> subscribe(
        observable: Single<ReturnType>,
        subscriber: DisposableSingleObserver<ReturnType>
    ) {
        compositeSubscription.add(observable
                .compose(rxUtilProvider.getNetworkToUiSingleTransformer<ReturnType>())
                .subscribe(subscriber::onSuccess, subscriber::onError))
    }

    protected fun <ReturnType> subscribe(
        observable: Observable<ReturnType>,
        onNext: (ReturnType) -> Unit,
        onError: (Throwable) -> Unit,
        onComplete: () -> Unit = {}
    ) {

        compositeSubscription.add(observable
            .compose(rxUtilProvider.getNetworkToUiObservableTransformer<ReturnType>())
            .subscribe(
                onNext,
                onError ,
                onComplete))
    }

    private fun cancel() {

        if (!compositeSubscription.isDisposed) {
            Timber.d("Cancelling Subscription For: %s", javaClass.name)
            compositeSubscription.clear()
        }
    }
}
