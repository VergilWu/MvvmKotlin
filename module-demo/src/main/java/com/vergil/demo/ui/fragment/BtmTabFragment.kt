package com.vergil.demo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.vergil.demo.BR
import com.vergil.demo.R
import com.vergil.demo.databinding.TestFragmentBtmtabBinding
import com.vergil.demo.ui.fragment.tab.TabBar1Fragment
import com.vergil.demo.ui.fragment.tab.TabBar2Fragment
import com.vergil.demo.ui.fragment.tab.TabBar3Fragment
import com.vergil.demo.ui.fragment.tab.TabBar4Fragment
import com.vergil.demo.ui.viewmodel.BtmTabViewModel
import com.vergil.mvvmlazy.base.fragment.BaseVmDbFragment
import java.util.*

class BtmTabFragment : BaseVmDbFragment<BtmTabViewModel,TestFragmentBtmtabBinding>() {
    override fun initContentView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): Int {
        return R.layout.test_fragment_btmtab
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun initData() {
        super.initData()
        val list: MutableList<Fragment> = ArrayList()
        list.add(TabBar1Fragment.newInstance())
        list.add(TabBar2Fragment.newInstance())
        list.add(TabBar3Fragment.newInstance())
        list.add(TabBar4Fragment.newInstance())
        binding.tabLayout.configTabLayoutConfig {
            onSelectIndexChange = { fromIndex, selectIndexList, reselect, fromUser ->
                val toIndex = selectIndexList[0]
                showFragment(list[toIndex], if (fromIndex >= 0) list[fromIndex] else null)
            }
        }
    }

    private fun showFragment(showFragment: Fragment, hideFragment: Fragment?) {
        val transaction = childFragmentManager.beginTransaction()
        if (showFragment.isAdded) {
            transaction.show(showFragment)
            transaction.setMaxLifecycle(showFragment, Lifecycle.State.RESUMED)
        } else {
            transaction.add(R.id.frame_container_layout, showFragment)
        }
        if (hideFragment != null) {
            if (hideFragment.isAdded) {
                transaction.hide(hideFragment)
                transaction.setMaxLifecycle(showFragment, Lifecycle.State.STARTED)
            }
        }
        transaction.commitAllowingStateLoss()
    }
}