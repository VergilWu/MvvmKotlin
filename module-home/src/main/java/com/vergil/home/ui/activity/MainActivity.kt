package com.vergil.home.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.vergil.base.router.RouterActivityPath
import com.vergil.home.BR
import com.vergil.home.R
import com.vergil.home.databinding.HomeActivityMainBinding
import com.vergil.home.ui.viewmodel.MainViewModel
import com.vergil.mvvmlazy.base.activity.BaseVmDbActivity

@Route(path = RouterActivityPath.Main.PAGER_MAIN)
class MainActivity : BaseVmDbActivity<MainViewModel, HomeActivityMainBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initContentView(): Int {
        return R.layout.home_activity_main
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun initData() {
        super.initData()
    }
}