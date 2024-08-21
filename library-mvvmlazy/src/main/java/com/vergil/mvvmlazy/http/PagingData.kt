package com.vergil.mvvmlazy.http

/**
 * ******************************
 * *description:分页数据类型封装
 * *******************************
 */
class PagingData<T> {
    var list: MutableList<T>? = null
    var total = 0
    var current = 0

}