package com.vergil.base.ui.fragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.angcyo.tablayout.delegate2.ViewPager2Delegate
import com.hjq.bar.TitleBar
import com.vergil.base.BR
import com.vergil.base.R
import com.vergil.base.databinding.BaseFragmentBasePagerBinding
import com.vergil.mvvmlazy.base.fragment.BaseVmDbFragment
import com.vergil.mvvmlazy.base.BaseViewModel

/**
 * 抽取的二级BasePagerFragment
 */
abstract class BasePagerFragment<VM : BaseViewModel> : BaseVmDbFragment<VM,BaseFragmentBasePagerBinding >() {
    private var mFragments: List<Fragment>? = null
    private var titlePager: List<String>? = null
    protected abstract fun pagerFragment(): List<Fragment>?
    protected abstract fun pagerTitleString(): List<String>?
    override fun initContentView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): Int {
        return R.layout.base_fragment_base_pager
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun initData() {
        mFragments = pagerFragment()
        titlePager = pagerTitleString()
        for (s in titlePager!!) {
            val tabTextView = TextView(requireContext())
            tabTextView.text = s
            tabTextView.gravity = Gravity.CENTER
            binding.tabLayout.addView(tabTextView)
        }
        //设置Adapter
        binding.viewPager.adapter = object : FragmentStateAdapter(this@BasePagerFragment) {
            override fun getItemCount(): Int {
                return mFragments!!.size
            }

            override fun createFragment(position: Int): Fragment {
                return mFragments!![position]
            }
        }
        binding.viewPager.currentItem = 0
        val viewPagerDelegate = ViewPager2Delegate(binding.viewPager, binding.tabLayout)
        binding.tabLayout.setupViewPager(viewPagerDelegate)
    }

    override fun initViewObservable() {}
    override fun initTitleBar(titleBar: TitleBar?) {
        super.initTitleBar(titleBar)
        titleBar!!.title = "tablayout示例"
    }
}