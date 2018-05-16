package de.zalando.lounge.ui.recyclerview

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.LinkedList

abstract class BaseRecyclerViewAdapter<ItemType, ViewHolderType : BaseViewHolder<ItemType>> : RecyclerView.Adapter<ViewHolderType> {

    private val itemList: MutableList<ItemType> = LinkedList()

    constructor()

    constructor(list: List<ItemType>) {
        itemList.addAll(list)
    }

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderType

    override fun onBindViewHolder(holder: ViewHolderType, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onViewRecycled(holder: ViewHolderType) {
        holder.unbind()
        super.onViewRecycled(holder)
    }

    override fun onViewAttachedToWindow(holder: ViewHolderType) {
        holder.onAttached()
    }

    override fun onViewDetachedFromWindow(holder: ViewHolderType) {
        holder.onDetached()
    }

    protected fun inflate(@LayoutRes layoutId: Int, parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
    }

    var items: List<ItemType>
        get() = itemList
        set(items) {
            itemList.clear()
            itemList.addAll(items)
            notifyDataSetChanged()
        }

    fun addItems(itemList: List<ItemType>) {
        this.itemList.addAll(itemList)
        notifyDataSetChanged()
    }

    fun clearItems() {
        itemList.clear()
        notifyDataSetChanged()
    }

    open fun getItem(position: Int): ItemType {
        return itemList[position]
    }

    fun getItemOrNull(position: Int): ItemType? {
        return itemList.getOrNull(position)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
