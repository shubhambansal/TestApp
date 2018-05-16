package de.zalando.lounge.di

import android.content.Context
import bansal.test.mobile.data.AndroidResourceProvider
import bansal.test.mobile.data.AppPreferences
import bansal.test.mobile.data.PreferencesStorage
import bansal.test.mobile.data.rest.RetrofitProvider
import bansal.test.mobile.data.room.ProtoAppDatabase
import bansal.test.mobile.ui.RxUtilProvider
import bansal.test.mobile.ui.base.BaseActivity
import bansal.test.mobile.ui.base.BaseFragment
import dagger.Subcomponent

@Subcomponent()
interface CoreComponent {


    fun rx(): RxUtilProvider
    fun resourceProvider(): AndroidResourceProvider
    fun retrofitProvider(): RetrofitProvider
    fun appPreferences(): AppPreferences
    fun preferences(): PreferencesStorage
    fun database() : ProtoAppDatabase

    fun context(): Context

    //region Injection Sites
    fun inject(baseActivity: BaseActivity)
    fun inject(baseFragment: BaseFragment)
    //endregion
}
