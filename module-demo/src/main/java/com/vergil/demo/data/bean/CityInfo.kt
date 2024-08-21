package com.vergil.demo.data.bean

import com.vergil.mvvmlazy.binding.viewadapter.spinner.IKeyAndValue

class CityInfo : IKeyAndValue {
    var name: String? = null
    var code: String? = null

    constructor(name: String?, code: String?) {
        this.name = name
        this.code = code
    }

    override fun loadKey(): String {
        return name ?: "";
    }

    override fun loadValue(): String {
        return code ?: "";
    }
}