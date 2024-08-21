package com.vergil.demo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.vergil.demo.BR
import com.vergil.demo.R
import com.vergil.demo.databinding.TestFragmentTitlebarBinding
import com.vergil.demo.ui.viewmodel.TitleBarViewModel
import com.vergil.mvvmlazy.base.fragment.BaseVmDbFragment

class TitleBarFragment : BaseVmDbFragment<TitleBarViewModel,TestFragmentTitlebarBinding>() {
    override fun initContentView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): Int {
        return R.layout.test_fragment_titlebar
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun initData() {
        super.initData()
    }
}