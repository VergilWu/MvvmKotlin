package com.vergil.mvvmlazy.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.LifecycleOwner

interface IBaseViewModel : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(owner: LifecycleOwner?, event: Lifecycle.Event?)

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate()

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart()

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume()

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause()
    fun initData()

    /**
     * 注册RxBus
     */
    fun registerEventBus()

    /**
     * 移除RxBus
     */
    fun removeEventBus()
}