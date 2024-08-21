package com.vergil.demo

import android.content.Context
import androidx.startup.Initializer
import com.vergil.mvvmlazy.utils.common.KLog

class DemoModuleInit : Initializer<Unit> {

    override fun create(context: Context) {
        KLog.d("demo组件初始化")
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}