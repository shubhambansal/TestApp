package bansal.test.mobile.ui;

import io.reactivex.*;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;

public class RxUtilProvider {

    @Inject
    public RxUtilProvider() {

    }

    public CompletableTransformer getNetworkToUiCompletableTransformer() {
        return new CompletableTransformer() {
            @Override
            public Completable apply(Completable observable) {
                return observable
                        .subscribeOn(getNetworkScheduler())
                        .observeOn(getUiScheduler());
            }
        };
    }

    public <Type> SingleTransformer<Type, Type> getNetworkToUiSingleTransformer() {
        return new SingleTransformer<Type, Type>() {
            @Override
            public Single<Type> apply(Single<Type> observable) {
                return observable
                        .subscribeOn(getNetworkScheduler())
                        .observeOn(getUiScheduler());
            }
        };
    }

    public <Type> MaybeTransformer<Type, Type> getNetworkToUiMaybeTransformer() {
        return new MaybeTransformer<Type, Type>() {
            @Override
            public Maybe<Type> apply(Maybe<Type> maybe) {
                return maybe
                        .subscribeOn(getNetworkScheduler())
                        .observeOn(getUiScheduler());
            }
        };
    }

    public <Type> ObservableTransformer<Type, Type> getNetworkToUiObservableTransformer() {
        return new ObservableTransformer<Type, Type>() {
            @Override
            public Observable<Type> apply(Observable<Type> observable) {
                return observable
                        .subscribeOn(getNetworkScheduler())
                        .observeOn(getUiScheduler());
            }
        };
    }

    public Scheduler getNetworkScheduler() {
        return Schedulers.io();
    }

    public Scheduler getUiScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
