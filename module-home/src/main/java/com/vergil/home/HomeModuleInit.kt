package com.vergil.home

import android.content.Context
import androidx.startup.Initializer
import com.vergil.mvvmlazy.utils.common.KLog

class HomeModuleInit : Initializer<Unit> {

    override fun create(context: Context) {
        KLog.d("首页组件初始化")
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}