package io.ak1.bubbletabbarapp.ui.samples

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import io.ak1.bubbletabbarapp.R
import io.ak1.bubbletabbarapp.databinding.FragmentViewPager2Binding
import io.ak1.bubbletabbarapp.ui.adapter.ViewPager2Adapter
import kotlin.reflect.KClass

class ViewPager2Fragment : BaseFragment() {
    override var viewType: KClass<*> = FragmentViewPager2Binding::class
    private val binding by lazy {
        mBinding as FragmentViewPager2Binding
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewpager2.apply {
            adapter = ViewPager2Adapter()
            registerOnPageChangeCallback(
                object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        binding.bubbleTabBar.setSelected(position)
                    }
                },
            )
        }

        binding.bubbleTabBar.addBubbleListener { id ->
            when (id) {
                R.id.home -> binding.viewpager2.currentItem = 0
                R.id.log -> binding.viewpager2.currentItem = 1
                R.id.doc -> binding.viewpager2.currentItem = 2
                R.id.setting -> binding.viewpager2.currentItem = 3
            }
        }
    }
}
