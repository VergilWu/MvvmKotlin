package com.vergil.mvvmlazy.base

/**
 * Description：RecycleView多布局ItemViewModel是封装
 */
class MultiItemViewModel<VM : BaseViewModel?>(viewModel: VM) : ItemViewModel<VM>(viewModel) {
    var itemType: Any? = null
        protected set

    fun multiItemType(multiType: Any) {
        itemType = multiType
    }
}