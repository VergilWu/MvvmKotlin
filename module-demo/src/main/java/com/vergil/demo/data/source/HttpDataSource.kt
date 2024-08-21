package com.vergil.demo.data.source

import com.vergil.base.entity.ApiResponse
import com.vergil.base.entity.ApiResponseTest
import com.vergil.demo.data.bean.JokeInfo
import com.vergil.mvvmlazy.http.PagingData
import retrofit2.http.Query

interface HttpDataSource {
    suspend  fun getJoke(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): ApiResponse<PagingData<JokeInfo>>
    suspend  fun testApi(
        @Query("q") page: String
    ):ApiResponseTest<Map<String,String>>
}