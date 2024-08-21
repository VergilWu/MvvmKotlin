package com.vergil.demo.ui.viewmodel

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.vergil.base.entity.ApiResponse
import com.vergil.base.ui.viewModel.BasePaginationViewModel
import com.vergil.demo.R
import com.vergil.demo.data.bean.JokeInfo
import com.vergil.demo.data.repository
import com.vergil.demo.databinding.TestLayoutItemJokeBinding
import com.vergil.mvvmlazy.binding.viewadapter.recyclerview.DataBindingAdapter
import com.vergil.mvvmlazy.http.PagingData

class PaginationViewModel : BasePaginationViewModel<JokeInfo>() {
    private val myAdapter by lazy {
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
    override val adapter: BaseQuickAdapter<JokeInfo, BaseViewHolder>
        get() = myAdapter

    /**
     * 接口数据格式通常有两种类型
     * 1.通常有不包含分页信息的,也就是data直接返回list
     * 2. 携带分页信息的,data包含分页信息和数据list
     * 根据接口数据类型选择解析方式
     * @return
     */
    override val dateListType: ListType
        get() = ListType.WITH_PAGING_INFO

    override suspend fun getHttpRequestWithPagingData(pageIndex: Int): ApiResponse<PagingData<JokeInfo>> {
        return repository.getJoke(pageIndex, 10 )
    }
}