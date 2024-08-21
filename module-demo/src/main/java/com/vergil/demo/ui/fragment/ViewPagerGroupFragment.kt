package com.vergil.demo.ui.fragment

import androidx.fragment.app.Fragment
import com.vergil.base.ui.fragment.BasePagerFragment
import com.vergil.demo.ui.fragment.tab.TabBar1Fragment
import com.vergil.demo.ui.fragment.tab.TabBar2Fragment
import com.vergil.demo.ui.fragment.tab.TabBar3Fragment
import com.vergil.demo.ui.fragment.tab.TabBar4Fragment
import com.vergil.mvvmlazy.base.BaseViewModel
import java.util.*

/**
 * Description：ViewPager+Fragment的实现
 */
class ViewPagerGroupFragment : BasePagerFragment<BaseViewModel>() {
    override fun pagerFragment(): List<Fragment> {
        val list: MutableList<Fragment> = ArrayList()
        list.add(TabBar1Fragment.newInstance())
        list.add(TabBar2Fragment.newInstance())
        list.add(TabBar3Fragment.newInstance())
        list.add(TabBar4Fragment.newInstance())
        return list
    }

    override fun pagerTitleString(): List<String> {
        val list: MutableList<String> = ArrayList()
        list.add("推荐")
        list.add("新闻")
        list.add("资讯")
        list.add("消息")
        return list
    }
}