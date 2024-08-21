package com.vergil.base.ui.viewModel

import androidx.lifecycle.MutableLiveData
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.vergil.base.entity.ApiResponse
import com.vergil.mvvmlazy.base.BaseViewModel
import com.vergil.mvvmlazy.binding.viewadapter.swiperefresh.SmartRefreshState
import com.vergil.mvvmlazy.ext.request
import com.vergil.mvvmlazy.http.PagingData
import com.vergil.mvvmlazy.widget.MultiStateView.ViewState

/**
 * 列表分页基类分装
 *
 * @param <M>
 * @param <T>
</T></M> */
abstract class BasePaginationViewModel<T> :
    BaseViewModel() {
    /**
     * 分页数据类型
     */
    enum class ListType {
        NO_PAGING_INFO,  //不包含分页信息
        WITH_PAGING_INFO
        //包含分页信息
    }

    //多状态布局控制
    var viewState = MutableLiveData(ViewState.LOADING)

    //下拉刷新,分页加载状态控制
    var smartRefreshState = MutableLiveData<SmartRefreshState>()
    var pageIndex = 1
    val pageSize = 10
    abstract val adapter: BaseQuickAdapter<T, BaseViewHolder>?
    abstract val dateListType: ListType
    var mAdapter: BaseQuickAdapter<T, BaseViewHolder>? = null

    /**
     * 未携带分页信息的请求
     *
     * @param pageIndex
     * @return
     */
    open suspend fun getHttpRequestNoPagingData(pageIndex: Int): ApiResponse<List<T>> {
        return ApiResponse(0, "", listOf())
    }

    /**
     * 携带分页信息的请求
     *
     * @param pageIndex
     * @return
     */
    open suspend fun getHttpRequestWithPagingData(pageIndex: Int): ApiResponse<PagingData<T>> {
        return ApiResponse(0, "", PagingData())
    }

    /**
     * 重新加载数据
     */
    var reTryLoad: () -> Unit = {
        pageIndex = 1
        getListData(pageIndex)
    }

    //加载更多数据
    var loadMore: () -> Unit = {
        getListData(pageIndex)
    }

    override fun initData() {
        super.initData()
        mAdapter = adapter
        getListData(pageIndex)
    }

    private fun getListData(page: Int) {
        when (dateListType) {
            ListType.NO_PAGING_INFO ->
                request({ getHttpRequestNoPagingData(page) }, {
                    if (page == 1) {
                        if (it.isNotEmpty()) {
                            mAdapter!!.setNewInstance(it.toMutableList())
                            viewState.setValue(ViewState.CONTENT)
                        } else {
                            viewState.setValue(ViewState.EMPTY)
                        }
                    } else {
                        mAdapter!!.addData(it)
                    }
                    if (it.size == pageSize) {
                        smartRefreshState.value = SmartRefreshState.LOAD_FINISH
                        pageIndex++
                    } else {
                        smartRefreshState.setValue(SmartRefreshState.LOAD_FINISH_NOMOREDATA)
                    }
                }, {
                    if (pageIndex == 1) {
                        viewState.setValue(ViewState.ERROR)
                    } else {
                        smartRefreshState.setValue(SmartRefreshState.LOAD_FINISH)
                    }
                })

            ListType.WITH_PAGING_INFO ->
                request({ getHttpRequestWithPagingData(page) }, {
                    if (page == 1) {
                        if (it.list!!.isNotEmpty()) {
                            mAdapter!!.setNewInstance(it.list)
                            viewState.setValue(ViewState.CONTENT)
                        } else {
                            viewState.setValue(ViewState.EMPTY)
                        }
                    } else {
                        mAdapter!!.addData(it.list!!)
                    }
                    if (it.list?.size == pageSize) {
                        smartRefreshState.value = SmartRefreshState.LOAD_FINISH
                        pageIndex++
                    } else {
                        smartRefreshState.value = SmartRefreshState.LOAD_FINISH_NOMOREDATA
                    }
                }, {
                    if (pageIndex == 1) {
                        with(viewState) { setValue(ViewState.ERROR) }
                    } else {
                        smartRefreshState.value = SmartRefreshState.LOAD_FINISH
                    }
                })


        }
    }
}