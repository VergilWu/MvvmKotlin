package com.vergil.demo.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.vergil.demo.data.bean.JokeInfo
import com.vergil.demo.data.repository
import com.vergil.mvvmlazy.base.BaseViewModel
import com.vergil.mvvmlazy.ext.request
import com.vergil.mvvmlazy.http.PagingData
import com.vergil.mvvmlazy.state.ResultState

class NetWorkViewModel : BaseViewModel() {
    var jokeInfo = MutableLiveData<ResultState<PagingData<JokeInfo>>>()
    var netDataStr = MutableLiveData<String>()
    var clickCommand1: () -> Unit = {
        getNetworkData1()
    }
    var clickCommand2: () -> Unit = {
        getNetworkData2()
    }

    /**
     * 在viewModel回调处理结果
     */
    private fun getNetworkData1() {
        request({ repository.getJoke(1, 10) }, {
            netDataStr.value = Gson().toJson(it)
        }, {

        }, isShowDialog = true, loadingMessage = "加载中,请稍后..")
    }

    /**
     * 将请求数据结果传给 MutableLiveData,通过页面检测处理结果
     */
    private fun getNetworkData2() {
        request(
            { repository.getJoke(1, 10) },
            jokeInfo,
            isShowDialog = true,
            loadingMessage = "加载中,请稍后.."
        )
    }
}