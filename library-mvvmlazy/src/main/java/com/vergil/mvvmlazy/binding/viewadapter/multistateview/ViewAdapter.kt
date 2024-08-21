package com.vergil.mvvmlazy.binding.viewadapter.multistateview

import android.view.View
import androidx.databinding.BindingAdapter
import com.vergil.mvvmlazy.widget.MultiStateView
import com.vergil.mvvmlazy.widget.MultiStateView.ViewState

object ViewAdapter {
    @JvmStatic
    @BindingAdapter("bindViewState")
    fun bindViewState(multiStateView: MultiStateView, viewState: ViewState?) {
        viewState?.let {
            multiStateView.viewState = viewState
        }
    }

    @JvmStatic
    @BindingAdapter("retryClick")
    fun retryClick(multiStateView: MultiStateView, clickCommand: () -> Unit) {
        clickCommand?.let {
            multiStateView.setOnEmptyClickListener { v: View? -> clickCommand.invoke() }
            multiStateView.setOnErrorClickListener { v: View? -> clickCommand.invoke() }
        }
    }
}