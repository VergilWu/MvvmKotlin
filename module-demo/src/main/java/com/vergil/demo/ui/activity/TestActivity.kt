package com.vergil.demo.ui.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.hjq.bar.TitleBar
import com.vergil.base.router.RouterActivityPath
import com.vergil.demo.BR
import com.vergil.demo.R
import com.vergil.demo.databinding.TestActivityTestBinding
import com.vergil.demo.ui.viewmodel.TestViewModel
import com.vergil.mvvmlazy.base.activity.BaseVmDbActivity

@Route(path = RouterActivityPath.Test.TESTPAGER)
class TestActivity : BaseVmDbActivity<TestViewModel, TestActivityTestBinding>() {
    override fun initContentView(): Int {
        return R.layout.test_activity_test
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun initData() {
        super.initData()
    }

    override fun initTitleBar(titleBar: TitleBar?) {
        super.initTitleBar(titleBar)
        titleBar!!.title = "demo测试"
    }
}