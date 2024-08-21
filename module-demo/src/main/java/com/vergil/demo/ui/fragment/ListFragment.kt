package com.vergil.demo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.vergil.demo.BR
import com.vergil.demo.R
import com.vergil.demo.databinding.TestFragmentListBinding
import com.vergil.demo.ui.viewmodel.ListViewModel
import com.vergil.mvvmlazy.base.fragment.BaseVmDbFragment

class ListFragment : BaseVmDbFragment<ListViewModel,TestFragmentListBinding>() {
    override fun initContentView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): Int {
        return R.layout.test_fragment_list
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun initData() {
        super.initData()
    }
}