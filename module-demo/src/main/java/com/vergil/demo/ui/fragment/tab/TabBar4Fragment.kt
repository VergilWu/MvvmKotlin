package com.vergil.demo.ui.fragment.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.vergil.demo.BR
import com.vergil.demo.R
import com.vergil.demo.databinding.TestFragmentTabBar4Binding
import com.vergil.mvvmlazy.base.fragment.BaseVmDbFragment
import com.vergil.mvvmlazy.base.BaseViewModel

class TabBar4Fragment : BaseVmDbFragment<BaseViewModel,TestFragmentTabBar4Binding>() {
    override fun initContentView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): Int {
        return R.layout.test_fragment_tab_bar_4
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    companion object {
        fun newInstance(): TabBar4Fragment {
            val args = Bundle()
            val fragment = TabBar4Fragment()
            fragment.arguments = args
            return fragment
        }
    }
}