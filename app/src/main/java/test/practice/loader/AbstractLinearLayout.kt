package test.practice.loader

import android.content.Context
import android.util.AttributeSet
import android.view.animation.Interpolator
import android.view.animation.LinearInterpolator
import android.widget.LinearLayout
import test.practice.R

abstract class AbstractLinearLayout : LinearLayout, LoaderContract {

    open var animDuration: Int = 500

    open var interpolator: Interpolator = LinearInterpolator()

    var dotsRadius: Int = 30

    var dotsDist: Int = 15

    var dotsColor: Int = resources.getColor(R.color.loader_defalut)

    abstract fun initView()

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

}