package bansal.test.mobile.data

import io.reactivex.functions.Function

abstract class Converter<FromType, ToType> : Function<FromType, ToType> {

    override fun apply(fromType: FromType): ToType {
        return convert(fromType)
    }

    abstract fun convert(element: FromType): ToType
}
