package com.vergil.demo.data

import androidx.lifecycle.LiveData
import com.vergil.base.entity.ApiResponse
import com.vergil.base.entity.ApiResponseTest
import com.vergil.base.network.RetrofitClient
import com.vergil.demo.data.bean.JokeInfo
import com.vergil.demo.data.source.HttpDataSource
import com.vergil.demo.data.source.LocalDataSource
import com.vergil.demo.data.source.http.HttpDataSourceImpl
import com.vergil.demo.data.source.http.service.HomeApiService
import com.vergil.demo.data.source.local.LocalDataSourceImpl
import com.vergil.demo.data.source.local.db.Person
import com.vergil.mvvmlazy.base.BaseModel
import com.vergil.mvvmlazy.http.PagingData

/**
 * ******************************
 * *@Author
 * *date ：
 * *description:MVVM的Model层，统一模块的数据仓库，包含网络数据和本地数据（一个应用可以有多个Repositor）
 * *******************************
 */
val repository: DiscoverRepository by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    DiscoverRepository()
}

class DiscoverRepository : BaseModel(), HttpDataSource, LocalDataSource {
    private val mHttpDataSource: HttpDataSource by lazy {
        HttpDataSourceImpl(
            RetrofitClient.instance.create(
                HomeApiService::class.java
            )
        )
    }
    private val mLocalDataSource: LocalDataSource by lazy {
        LocalDataSourceImpl()
    }

    override fun insertWords(vararg words: Person) {
        mLocalDataSource.insertWords(*words)
    }

    override fun updateWords(vararg words: Person) {
        mLocalDataSource.updateWords(*words)
    }

    override fun deleteWords(vararg words: Person) {
        mLocalDataSource.deleteWords(*words)
    }

    override fun deleteAllWords() {
        mLocalDataSource.deleteAllWords()
    }

    override fun getAllWordsLive(): LiveData<List<Person>> {
        return mLocalDataSource.getAllWordsLive()
    }

    override suspend fun getJoke(
        page: Int,
        size: Int
    ): ApiResponse<PagingData<JokeInfo>> {
        return mHttpDataSource.getJoke(page, size)
    }

    override suspend fun testApi(page: String): ApiResponseTest<Map<String, String>> {
        return mHttpDataSource.testApi(page)
    }
}