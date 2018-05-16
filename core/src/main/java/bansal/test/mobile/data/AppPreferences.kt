package bansal.test.mobile.data

import javax.inject.Inject
import javax.inject.Singleton



@Singleton
class AppPreferences @Inject constructor(preferencesStorage: PreferencesStorage) {

    companion object {
        const val APP_SHARED_PREFERENCE_FILE = "app.preference"
    }
}