package bansal.test.mobile.data

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

/**
 * PreferencesStorage provides persistent storage layer for primitive values
 */
@Singleton
open class PreferencesStorage
@Inject constructor(private val sharedPreferences: SharedPreferences) {

    open fun contains(key: String): Boolean {
        return sharedPreferences.contains(key)
    }

    open fun putString(key: String, value: String?) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    open fun putInt(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    open fun putLong(key: String, value: Long) {
        sharedPreferences.edit().putLong(key, value).apply()
    }

    open fun putBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    open fun getString(key: String, defValue: String?): String? {
        return sharedPreferences.getString(key, defValue)
    }

    open fun getInt(key: String, defValue: Int): Int {
        return sharedPreferences.getInt(key, defValue)
    }

    open fun getLong(key: String, defValue: Long): Long {
        return sharedPreferences.getLong(key, defValue)
    }

    open fun getBoolean(key: String, defValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defValue)
    }

    open fun removeKey(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }
}
