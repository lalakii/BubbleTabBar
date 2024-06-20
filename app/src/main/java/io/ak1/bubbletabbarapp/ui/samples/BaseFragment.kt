package io.ak1.bubbletabbarapp.ui.samples

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.ak1.bubbletabbarapp.databinding.FragmentNavControllerBinding
import io.ak1.bubbletabbarapp.databinding.FragmentViewPager2Binding
import io.ak1.bubbletabbarapp.databinding.FragmentViewPagerBinding
import kotlin.reflect.KClass

abstract class BaseFragment : Fragment() {
    abstract var viewType: KClass<*>
    lateinit var mBinding: Any

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        when (viewType) {
            FragmentNavControllerBinding::class -> {
                val binding = FragmentNavControllerBinding.inflate(inflater, container, false)
                mBinding = binding
                return binding.root
            }

            FragmentViewPager2Binding::class -> {
                val binding = FragmentViewPager2Binding.inflate(inflater, container, false)
                mBinding = binding
                return binding.root
            }

            FragmentViewPagerBinding::class -> {
                val binding = FragmentViewPagerBinding.inflate(inflater, container, false)
                mBinding = binding
                return binding.root
            }

            else -> return null
        }
    }
}
