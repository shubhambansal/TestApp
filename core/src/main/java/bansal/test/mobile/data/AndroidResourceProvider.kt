package bansal.test.mobile.data

import android.content.Context

import android.support.annotation.BoolRes
import android.support.annotation.ColorRes
import android.support.annotation.StringRes
import android.support.v4.content.res.ResourcesCompat

import javax.inject.Inject

class AndroidResourceProvider
@Inject constructor(private val context: Context) {

    fun getString(@StringRes resourceId: Int) = context.getString(resourceId)

    fun getBoolean(@BoolRes resourceId: Int) = context.resources.getBoolean(resourceId)

    fun getColor(@ColorRes colorId: Int) = ResourcesCompat.getColor(context.resources, colorId, null)
}
