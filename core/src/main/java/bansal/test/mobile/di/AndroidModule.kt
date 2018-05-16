package bansal.test.mobile.di

import android.content.Context
import android.content.SharedPreferences
import bansal.test.mobile.data.AppPreferences
import dagger.Module
import dagger.Provides

@Module
class AndroidModule {

    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(AppPreferences.APP_SHARED_PREFERENCE_FILE, Context.MODE_PRIVATE)
    }
}
