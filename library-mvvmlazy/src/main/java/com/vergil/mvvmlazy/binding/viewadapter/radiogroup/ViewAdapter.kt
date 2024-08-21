package com.vergil.mvvmlazy.binding.viewadapter.radiogroup

import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.databinding.BindingAdapter

object ViewAdapter {
    @JvmStatic
    @BindingAdapter(value = ["onCheckedChangedCommand"], requireAll = false)
    fun onCheckedChangedCommand(radioGroup: RadioGroup, bindingCommand: (String) -> Unit) {
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = group.findViewById<View>(checkedId) as RadioButton
            bindingCommand.invoke(radioButton.text.toString())
        }
    }
}