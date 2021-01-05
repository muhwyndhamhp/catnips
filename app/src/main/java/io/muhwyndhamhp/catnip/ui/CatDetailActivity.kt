package io.muhwyndhamhp.catnip.ui

import android.os.Bundle
import android.view.MotionEvent
import androidx.navigation.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import io.muhwyndhamhp.catnip.base.BaseActivity
import io.muhwyndhamhp.catnip.databinding.ActivityCatDetailBinding
import io.muhwyndhamhp.catnip.ui.adapter.CatAdapter
import io.muhwyndhamhp.catnip.ui.adapter.PagerDecorator
import io.muhwyndhamhp.catnip.util.Constants.CAT_IMAGE_VIEW

class CatDetailActivity : BaseActivity() {

    lateinit var binding: ActivityCatDetailBinding
    private val arguments: CatDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCatDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pagerDecorator = PagerDecorator(arguments.cat.images.size)
        binding.rvImages.apply {
            addItemDecoration(pagerDecorator)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = CatAdapter(
                itemViewType = CAT_IMAGE_VIEW,
                imageList = arguments.cat.images
            ) { _, _ -> }
        }
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.rvImages)
    }
}