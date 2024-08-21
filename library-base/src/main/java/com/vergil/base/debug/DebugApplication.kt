package com.vergil.base.debug

import android.app.Application

/**
 * debug包下的代码不参与编译，仅作为独立模块运行时初始化数据
 */
class DebugApplication : Application() {
    override fun onCreate() {
        super.onCreate()

    }
}