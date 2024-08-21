package com.vergil.demo.ui.viewmodel

import androidx.lifecycle.LiveData
import com.vergil.demo.data.repository
import com.vergil.demo.data.source.local.db.Person
import com.vergil.mvvmlazy.base.BaseViewModel
import com.vergil.mvvmlazy.ext.launch

/**
 * 实现Room数据的基本操作
 */
class RoomSampleViewModel() :
    BaseViewModel() {

    val allWordsLive: LiveData<List<Person>>
        get() = repository.getAllWordsLive()

    fun insertWords(vararg words: Person) {
        launch({ repository.insertWords(*words) }, {})
    }

    fun updateWords(vararg words: Person) {
        launch({ repository.updateWords(*words) }, {})

    }

    fun deleteWords(vararg words: Person) {
        launch({ repository.deleteWords(*words) }, {})
    }

    fun deleteAllWords() {
        launch({ repository.deleteAllWords() }, {})
    }
}