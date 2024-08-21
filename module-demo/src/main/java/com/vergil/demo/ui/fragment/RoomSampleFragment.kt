package com.vergil.demo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vergil.demo.BR
import com.vergil.demo.R
import com.vergil.demo.data.source.local.db.Person
import com.vergil.demo.databinding.TestFragmentRoomBinding
import com.vergil.demo.ui.viewmodel.RoomSampleViewModel
import com.vergil.mvvmlazy.base.fragment.BaseVmDbFragment
import java.util.*

/**
 * 实现Room数据的基本操作
 */
class RoomSampleFragment : BaseVmDbFragment<RoomSampleViewModel, TestFragmentRoomBinding>() {
    var personList: MutableList<Person> = ArrayList()
    override fun initContentView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): Int {
        return R.layout.test_fragment_room
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun initData() {
        super.initData()
    }

    override fun initViewObservable() {
        super.initViewObservable()
        viewModel.allWordsLive.observe(this, { words: List<Person> ->
            personList.clear()
            personList.addAll(words)
            val text = StringBuilder()
            for (i in words.indices) {
                val person = words[i]
                text.append(person.id).append(":").append(person.name).append("  ")
                    .append(person.age).append("\n")
            }
            binding.textView.text = text.toString()
        })
        binding.buttonInsert.setOnClickListener { v: View? ->
            val person = Person("大壮", "11")
            viewModel.insertWords(person)
        }
        binding.buttonClear.setOnClickListener { v: View? -> viewModel.deleteAllWords() }
        binding.buttonUpdate.setOnClickListener { v: View? ->
            for (person in personList) {
                person.name = person.name + "更新"
                person.age = (person.age.toInt() + 1).toString()
                viewModel.updateWords(person)
            }
        }
        binding.buttonDelete.setOnClickListener { v: View? ->
            if (personList.size > 0) {
                viewModel.deleteWords(personList[0])
            }
        }
    }
}