package com.vergil.demo.data.source

import androidx.lifecycle.LiveData
import com.vergil.demo.data.source.local.db.Person

interface LocalDataSource {
    fun insertWords(vararg words: Person)
    fun updateWords(vararg words: Person)
    fun deleteWords(vararg words: Person)
    fun deleteAllWords()
    fun getAllWordsLive(): LiveData<List<Person>>
}