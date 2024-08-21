package com.vergil.mvvmlazy.widget

import android.content.Context
import android.widget.LinearLayout
import android.view.MotionEvent
import android.util.AttributeSet
import com.vergil.mvvmlazy.R

/**
 * 控制事件分发的LinearLayout
 */
class ControlDistributeLinearLayout(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    //默认是不拦截事件,分发事件给子View
    var isDistributeEvent = false

    /**
     * 重写事件分发方法,false 为分发 , true 为父控件自己消耗, 由外面传进来的参数决定
     */
    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return isDistributeEvent
    }

    init {
        val typedArray =
            getContext().obtainStyledAttributes(attrs, R.styleable.ControlDistributeLinearLayout)
        isDistributeEvent =
            typedArray.getBoolean(R.styleable.ControlDistributeLinearLayout_distribute_event, false)
    }
}