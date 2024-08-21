package com.vergil.home.data

import com.vergil.base.network.RetrofitClient
import com.vergil.home.data.source.HttpDataSource
import com.vergil.home.data.source.LocalDataSource
import com.vergil.home.data.source.http.HttpDataSourceImpl
import com.vergil.home.data.source.http.service.HomeApiService
import com.vergil.home.data.source.local.LocalDataSourceImpl
import com.vergil.mvvmlazy.base.BaseModel

/**
 * ******************************
 * *@Author
 * *date ：
 * *description:MVVM的Model层，统一模块的数据仓库，包含网络数据和本地数据（一个应用可以有多个Repositor）
 * *******************************
 */
val repository: HomeRepository by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    HomeRepository()
}

class HomeRepository : BaseModel(), HttpDataSource, LocalDataSource {
    private val mHttpDataSource by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        HttpDataSourceImpl(
            RetrofitClient.instance.create(
                HomeApiService::class.java
            )
        )
    }
    private val mLocalDataSource by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        LocalDataSourceImpl()
    }

    override fun saveUserName(userName: String) {
        mLocalDataSource.saveUserName(userName)
    }

    override fun savePassword(password: String) {
        mLocalDataSource.savePassword(password)
    }

    override fun getUserName(): String {
        return mLocalDataSource.userName
    }

    override fun getPassword(): String {
        return mLocalDataSource.password
    }


}