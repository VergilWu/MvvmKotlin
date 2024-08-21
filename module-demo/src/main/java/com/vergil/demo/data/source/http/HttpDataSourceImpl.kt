package com.vergil.demo.data.source.http

import com.vergil.base.entity.ApiResponse
import com.vergil.base.entity.ApiResponseTest
import com.vergil.demo.data.bean.JokeInfo
import com.vergil.demo.data.source.HttpDataSource
import com.vergil.demo.data.source.http.service.HomeApiService
import com.vergil.mvvmlazy.http.PagingData

class HttpDataSourceImpl(var apiService: HomeApiService) : HttpDataSource {
    override suspend fun getJoke(
        page: Int,
        size: Int
    ): ApiResponse<PagingData<JokeInfo>> {
        return apiService.getJoke(page, size)
    }

    override suspend fun testApi(page: String): ApiResponseTest<Map<String, String>> {
        return apiService.testApi(page)
    }


}