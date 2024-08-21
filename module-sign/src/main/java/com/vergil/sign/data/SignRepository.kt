package com.vergil.sign.data

import com.vergil.base.network.RetrofitClient
import com.vergil.mvvmlazy.base.BaseModel
import com.vergil.sign.data.source.HttpDataSource
import com.vergil.sign.data.source.LocalDataSource
import com.vergil.sign.data.source.http.HttpDataSourceImpl
import com.vergil.sign.data.source.http.service.SignApiService
import com.vergil.sign.data.source.local.LocalDataSourceImpl

/**
 * ******************************
 * *@Author
 * *date ：
 * *description:MVVM的Model层，统一模块的数据仓库，包含网络数据和本地数据（一个应用可以有多个Repositor）
 * *******************************
 */
val repository: SignRepository by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    SignRepository()
}

class SignRepository : BaseModel(), HttpDataSource, LocalDataSource {
    private val mHttpDataSource by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        HttpDataSourceImpl(
            RetrofitClient.instance.create(
                SignApiService::class.java
            )
        )
    }
    private val mLocalDataSource by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        LocalDataSourceImpl()
    }
}