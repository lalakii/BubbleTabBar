package io.ak1.bubbletabbarapp.ui.samples

import android.os.Bundle
import android.view.View
import io.ak1.bubbletabbarapp.R
import io.ak1.bubbletabbarapp.databinding.FragmentViewPagerBinding
import io.ak1.bubbletabbarapp.ui.adapter.ViewPagerAdapter
import io.ak1.bubbletabbarapp.utils.PresentationViewPager
import io.ak1.bubbletabbarapp.utils.setupViewPager
import kotlin.reflect.KClass

class ViewPagerFragment : BaseFragment() {
    override var viewType: KClass<*> = FragmentViewPagerBinding::class
    private val binding by lazy {
        mBinding as FragmentViewPagerBinding
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewpager.apply {
            setDurationScroll(PresentationViewPager.PRESENTATION_MODE_SCROLL_DURATION)
            adapter = ViewPagerAdapter(childFragmentManager)
        }
        binding.bubbleTabBar.setupViewPager(binding.viewpager)
        binding.bubbleTabBar.addBubbleListener { id ->
            when (id) {
                R.id.home -> binding.viewpager.currentItem = 0
                R.id.log -> binding.viewpager.currentItem = 1
                R.id.doc -> binding.viewpager.currentItem = 2
                R.id.setting -> binding.viewpager.currentItem = 3
            }
        }
    }
}
