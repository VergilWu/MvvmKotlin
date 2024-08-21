package com.vergil.demo.data.source.http.service

import com.vergil.base.entity.ApiResponse
import com.vergil.base.entity.ApiResponseTest
import com.vergil.demo.data.bean.JokeInfo
import com.vergil.mvvmlazy.http.PagingData
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * ******************************
 * *@Author
 * *date ：
 * *description:接口服务类
 * *******************************
 */
interface HomeApiService {
    @GET("api/getImages")
    suspend fun getJoke(
        @Query("page") page: Int,
        @Query("size") count: Int,
    ): ApiResponse<PagingData<JokeInfo>>
    @GET("https://insdoss.freeapptools.com/api/test")
    suspend fun testApi(
        @Query("q") page: String,
    ): ApiResponseTest<Map<String,String>>
}