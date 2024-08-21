package com.vergil.base.base

import android.app.Application
import android.content.Context
import androidx.startup.Initializer
import com.alibaba.android.arouter.launcher.ARouter
import com.vergil.mvvmlazy.utils.app.ProcessUtils
import com.vergil.mvvmlazy.utils.common.KLog
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.zzhoujay.richtext.RichText

/**
 * ******************************
 * *description:基础库初始化
 * *******************************
 */
class BaseModuleInit : Initializer<Unit> {
    companion object {
        init {
            //设置全局的Header构建器
            SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
                layout.setPrimaryColorsId(android.R.color.white, android.R.color.black) //全局设置主题颜色
                ClassicsHeader(context).setEnableLastTime(false)
            }
            //设置全局的Footer构建器
            SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout -> //指定为经典Footer，默认是 BallPulseFooter
                ClassicsFooter(context).setDrawableSize(20f)
            }
        }
    }


    override fun create(context: Context) {
        //开启打印日志
        KLog.init(true)
        //初始化阿里路由框架
        if (ProcessUtils.isApkInDebug()) {
            ARouter.openLog() // 打印日志
            ARouter.openDebug() // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(context.applicationContext as Application?) // 尽可能早，推荐在Application中初始化
        RichText.initCacheDir(context)
        KLog.d("基础层初始化")
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}