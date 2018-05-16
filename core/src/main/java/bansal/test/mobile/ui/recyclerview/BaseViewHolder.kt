package de.zalando.lounge.ui.recyclerview

import android.content.Context

import android.support.v7.widget.RecyclerView

import android.view.View

abstract class BaseViewHolder<in T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val context: Context = itemView.context

    abstract fun bind(item: T)
    open fun unbind() {}

    open fun onAttached() {}
    open fun onDetached() {}
}
