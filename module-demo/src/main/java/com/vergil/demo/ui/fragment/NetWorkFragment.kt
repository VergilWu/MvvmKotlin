package com.vergil.demo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.gson.Gson
import com.vergil.demo.BR
import com.vergil.demo.R
import com.vergil.demo.databinding.TestFragmentNetWorkBinding
import com.vergil.demo.ui.viewmodel.NetWorkViewModel
import com.vergil.mvvmlazy.base.fragment.BaseVmDbFragment
import com.vergil.mvvmlazy.ext.parseState
import com.vergil.mvvmlazy.utils.common.ToastUtils

class NetWorkFragment : BaseVmDbFragment<NetWorkViewModel,TestFragmentNetWorkBinding>() {
    override fun initContentView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): Int {
        return R.layout.test_fragment_net_work
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun initData() {
        super.initData()
    }

    override fun initViewObservable() {
        super.initViewObservable()
        viewModel.jokeInfo.observe(this) { resultState ->
            parseState(resultState, {
                viewModel.netDataStr.value = Gson().toJson(it)
            }, {
                ToastUtils.showShort(it.errorMsg)
            })
        }
    }
}