package com.vergil.home.data.source.local

import com.vergil.home.data.source.LocalDataSource
import com.vergil.mvvmlazy.utils.data.SPUtils

/**
 * 本地数据源，可配合Room框架使用
 */


class LocalDataSourceImpl : LocalDataSource {
    override fun saveUserName(userName: String) {
        SPUtils.instance.put("UserName", userName)
    }

    override fun savePassword(password: String) {
        SPUtils.instance.put("password", password)
    }

    override fun getUserName(): String {
        return SPUtils.instance.getString("UserName")!!
    }

    override fun getPassword(): String {
        return SPUtils.instance.getString("password")!!
    }

}