package com.vergil.demo.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lxj.xpopupext.listener.CityPickerListener
import com.lxj.xpopupext.listener.CommonPickerListener
import com.lxj.xpopupext.listener.TimePickerListener
import com.lxj.xpopupext.popup.TimePickerPopup
import com.vergil.base.utils.DialogUtils.cancelLoading
import com.vergil.base.utils.DialogUtils.showAttachList
import com.vergil.base.utils.DialogUtils.showBtmListDialog
import com.vergil.base.utils.DialogUtils.showCityDialog
import com.vergil.base.utils.DialogUtils.showCommentDialog
import com.vergil.base.utils.DialogUtils.showConfirmDialog
import com.vergil.base.utils.DialogUtils.showHintError
import com.vergil.base.utils.DialogUtils.showHintFinish
import com.vergil.base.utils.DialogUtils.showHintWarning
import com.vergil.base.utils.DialogUtils.showInputDialog
import com.vergil.base.utils.DialogUtils.showLoading
import com.vergil.base.utils.DialogUtils.showNormalListDialog
import com.vergil.base.utils.DialogUtils.showTimeDialog
import com.vergil.demo.BR
import com.vergil.demo.R
import com.vergil.demo.databinding.TestFragmentDialogBinding
import com.vergil.demo.ui.viewmodel.DialogViewModel
import com.vergil.mvvmlazy.base.fragment.BaseVmDbFragment
import com.vergil.mvvmlazy.utils.common.ToastUtils
import java.util.*

class DialogFragment : BaseVmDbFragment<DialogViewModel,TestFragmentDialogBinding>() {
    override fun initContentView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): Int {
        return R.layout.test_fragment_dialog
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun initData() {
        super.initData()
        binding.presenter = Presenter()
    }

    inner class Presenter {
        fun msgClick() {
            showConfirmDialog(
                "哈哈",
                "床前明月光，疑是地上霜；举头望明月，低头思故乡。",
                { ToastUtils.showShort("click confirm") },
                null
            )
        }

        fun inputDialogClick() {
            showInputDialog("我是标题", null) { text -> ToastUtils.showShort(text) }
        }

        fun hintDialogClick(type: Int) {
            when (type) {
                1 -> showHintFinish("完成")
                2 -> showHintError("错误")
                3 -> showHintWarning("警告")
                else -> {
                }
            }
        }

        fun loadingDialogClick() {
            val loadingPopup = showLoading("加载中")
            loadingPopup!!.postDelayed({
                loadingPopup.setTitle("加载中长度变化啊")
                loadingPopup.postDelayed({
                    loadingPopup.setTitle("")
                    cancelLoading()
                }, 2000)
            }, 2000)
        }

        fun spinnerDialogClick(v: View?) {
            showAttachList(
                v, arrayOf(
                    "分享", "编辑", "分享", "编辑"
                ),
                null
            ) { position, text -> ToastUtils.showShort("click $text") }
        }

        fun commentDialogClick() {
            showCommentDialog { text -> ToastUtils.showShort(text) }
        }

        fun btmListDialogClick() {
            showBtmListDialog(
                "请选择一项", arrayOf("条目1", "条目2", "条目3", "条目4", "条目5", "条目6", "条目7")
            ) { position, text -> ToastUtils.showShort("click $text") }
        }

        fun btmListCheckDialogClick() {
            showBtmListDialog(
                "标题可以没有", arrayOf("条目1", "条目2", "条目3", "条目4", "条目5"),
                null, 2
            ) { position, text -> ToastUtils.showShort("click $text") }
        }

        fun dateDialogClick() {
            showTimeDialog(TimePickerPopup.Mode.YMD, object : TimePickerListener {
                override fun onTimeChanged(date: Date) {}
                override fun onTimeConfirm(date: Date, view: View) {
                    //点击确认时间
                    ToastUtils.showShort("选择的时间：" + date.toLocaleString())
                }

                override fun onCancel() {
                }
            })
        }

        fun cityDialogClick() {
            showCityDialog(object : CityPickerListener {
                override fun onCityConfirm(province: String, city: String, area: String, v: View) {
                    Log.e("tag", "$province - $city - $area")
                    ToastUtils.showShort("$province - $city - $area")
                }

                override fun onCityChange(province: String, city: String, area: String) {
                    Log.e("tag", "$province - $city - $area")
                    ToastUtils.showShort("$province - $city - $area")
                }

                override fun onCancel() {
                }
            })
        }

        fun norListDialogClick() {
            val list = ArrayList<String?>()
            list.add("小猫")
            list.add("小狗")
            list.add("小羊")
            list.add("小鸡")
            list.add("小鸭")
            showNormalListDialog(list,object :CommonPickerListener{
                override fun onItemSelected(index: Int, data: String) {
                    ToastUtils.showShort("选中的是 $data")
                }

                override fun onCancel() {
                    TODO("Not yet implemented")
                }
            })
        }
    }
}