package com.example.headspaceapplication.extensions

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun <T : ViewDataBinding> ViewGroup.bind(layoutId: Int, attachToParent: Boolean = false): T =
    DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, this, attachToParent)

@BindingAdapter("htmlText")
fun TextView.htmlText(text: String?) {
    setText("")
    text?.let { setText(HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT)) }
}
