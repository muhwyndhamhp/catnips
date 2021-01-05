package io.muhwyndhamhp.catnip.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.muhwyndhamhp.catnip.R
import io.muhwyndhamhp.catnip.databinding.ItemCatBinding
import io.muhwyndhamhp.catnip.databinding.ItemCatImageBinding
import io.muhwyndhamhp.catnip.model.Cat
import io.muhwyndhamhp.catnip.util.Constants.CAT_VIEW

class CatAdapter(
    val itemViewType: Int,
    val catList: List<Cat>? = listOf(),
    val imageList: List<String>? = listOf(),
    val listener: (Cat, Int) -> Unit
) : RecyclerView.Adapter<CatAdapter.BaseViewHolder>() {

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bindItem(item: Any?, position: Int, listener: (Cat, Int) -> Unit)
    }

    class CatViewHolder(private val itemCatBinding: ItemCatBinding) :
        BaseViewHolder(itemCatBinding.root) {
        override fun bindItem(item: Any?, position: Int, listener: (Cat, Int) -> Unit) {
            val cat = item as Cat
            itemCatBinding.cat = cat
            itemCatBinding.root.setOnClickListener { listener.invoke(cat, position) }
        }
    }

    class CatImageViewHolder(private val itemCatImageBinding: ItemCatImageBinding) :
        BaseViewHolder(itemCatImageBinding.root) {
        override fun bindItem(item: Any?, position: Int, listener: (Cat, Int) -> Unit) {
            val imageUrl = item as String
            itemCatImageBinding.catUrl = imageUrl
        }

    }

    override fun getItemViewType(position: Int) = itemViewType

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            CAT_VIEW -> CatViewHolder(
                DataBindingUtil.inflate(
                    layoutInflater,
                    R.layout.item_cat,
                    parent,
                    false
                )
            )
            else -> CatImageViewHolder(
                DataBindingUtil.inflate(
                    layoutInflater,
                    R.layout.item_cat_image,
                    parent,
                    false
                )
            )
        }

    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (itemViewType) {
            CAT_VIEW -> holder.bindItem(catList?.get(position), position, listener)
            else -> holder.bindItem(imageList?.get(position), position, listener)
        }
    }

    override fun getItemCount() = when (itemViewType) {
        CAT_VIEW -> catList?.size ?: 0
        else -> imageList?.size ?: 0
    }

}