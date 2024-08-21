package com.vergil.demo.ui.viewmodel

import android.widget.LinearLayout
import androidx.lifecycle.MutableLiveData
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.vergil.demo.R
import com.vergil.demo.data.bean.JokeInfo
import com.vergil.demo.databinding.TestLayoutItemJokeBinding
import com.vergil.mvvmlazy.base.BaseViewModel
import com.vergil.mvvmlazy.binding.viewadapter.recyclerview.DataBindingAdapter
import com.vergil.mvvmlazy.utils.common.ScreenUtil.sp2px
import java.util.*

class ListViewModel : BaseViewModel() {
    var type = MutableLiveData(1)
    override fun initData() {
        super.initData()
        val list1: MutableList<JokeInfo> = ArrayList()
        repeat(35) {
            list1.add(JokeInfo("测试一下", "小明"))
        }

        lineAdapter.setNewInstance(list1)
        val list2: MutableList<JokeInfo> = ArrayList()
        repeat(35) {
            list2.add(JokeInfo("测试一下", "小明"))
        }
        gridAdapter.setNewInstance(list2)
        val list3: MutableList<JokeInfo> = ArrayList()
        repeat(35) {
            list3.add(JokeInfo("测试一下", "小明"))
        }
        staggeredAdapter.setNewInstance(list3)
    }

    val lineAdapter by lazy {
        object :
            DataBindingAdapter<JokeInfo, TestLayoutItemJokeBinding>(R.layout.test_layout_item_joke) {
            override fun convertItem(
                holder: BaseViewHolder,
                binding: TestLayoutItemJokeBinding?,
                item: JokeInfo
            ) {
                binding!!.entity = item
            }
        }
    }
    val gridAdapter by lazy {
        object :
            DataBindingAdapter<JokeInfo, TestLayoutItemJokeBinding>(R.layout.test_layout_item_joke) {
            override fun convertItem(
                holder: BaseViewHolder,
                binding: TestLayoutItemJokeBinding?,
                item: JokeInfo
            ) {
                binding!!.entity = item
            }
        }
    }
    val staggeredAdapter by lazy {
        object :
            DataBindingAdapter<JokeInfo, TestLayoutItemJokeBinding>(R.layout.test_layout_item_joke) {
            override fun convertItem(
                holder: BaseViewHolder,
                binding: TestLayoutItemJokeBinding?,
                item: JokeInfo
            ) {
                binding!!.entity = item
                val layoutParams = binding.llParent.layoutParams as LinearLayout.LayoutParams
                when (holder.bindingAdapterPosition % 3) {
                    0 -> {
                        layoutParams.height = sp2px(context, 60f)
                    }
                    1 -> {
                        layoutParams.height = sp2px(context, 80f)
                    }
                    else -> {
                        layoutParams.height = sp2px(context, 100f)
                    }
                }
                binding.llParent.layoutParams = layoutParams
            }
        }
    }

    fun changeType(typeValue: Int) {
        type.value = typeValue
    }
}