package io.ak1.bubbletabbarapp.ui.samples

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import io.ak1.bubbletabbarapp.R
import io.ak1.bubbletabbarapp.databinding.FragmentNavControllerBinding
import io.ak1.bubbletabbarapp.utils.onNavDestinationSelected
import kotlin.reflect.KClass

class NavControllerFragment : BaseFragment() {
    override var viewType: KClass<*> = FragmentNavControllerBinding::class
    private val binding by lazy {
        mBinding as FragmentNavControllerBinding
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        val navHostFragment =
            childFragmentManager
                .findFragmentById(R.id.inner_host_nav) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bubbleTabBar.addBubbleListener { id ->
            onNavDestinationSelected(id, navController)
        }
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.bubbleTabBar.setSelectedWithId(destination.id, false)
        }
    }
}
