package com.vergil.home.data.source.http

import com.vergil.home.data.source.HttpDataSource
import com.vergil.home.data.source.http.service.HomeApiService

class HttpDataSourceImpl(val apiService: HomeApiService) : HttpDataSource {
}