package io.muhwyndhamhp.catnip.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import io.muhwyndhamhp.catnip.R

object BindingAdapters {
    @BindingAdapter("app:imageUrl")
    @JvmStatic
    fun loadImage(view: ImageView, url: String?) {
        Glide.with(view.context).load(url ?: R.drawable.ic_kitty).into(view)
    }
}