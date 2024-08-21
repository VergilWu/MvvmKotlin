package com.vergil.demo.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.vergil.demo.data.bean.CityInfo
import com.vergil.mvvmlazy.base.BaseViewModel
import com.vergil.mvvmlazy.binding.viewadapter.spinner.IKeyAndValue
import com.vergil.mvvmlazy.utils.common.ToastUtils
import java.util.*

class BindingViewModel : BaseViewModel() {
    var imgUrl =
        MutableLiveData("http://video.hnbxwhy.com/ads/77b65f2b-e31d-4cfd-b6d9-39ee1f9dfc78.jpg")
    var data = MutableLiveData<List<IKeyAndValue>>()
    var clickCommand: () -> Unit = {
        ToastUtils.showShort("点到我了")
    }
    var swichCommand: (Boolean) -> Unit = {
        ToastUtils.showShort("开关$it")
    }
    var checkCommand: (Boolean) -> Unit = {
        ToastUtils.showShort("选中$it")
    }
    var selectCommand: (IKeyAndValue) -> Unit = {
        ToastUtils.showShort("选中" + it.key)
    }


    override fun initData() {
        super.initData()
        val iKeyAndValues: MutableList<IKeyAndValue> = ArrayList()
        iKeyAndValues.add(CityInfo("中国", "111"))
        iKeyAndValues.add(CityInfo("美国", "122"))
        iKeyAndValues.add(CityInfo("日本", "133"))
        iKeyAndValues.add(CityInfo("英国", "143"))
        data.value = iKeyAndValues
    }
}