package io.ak1.bubbletabbarapp.ui.home
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.ak1.bubbletabbarapp.R
import io.ak1.bubbletabbarapp.databinding.FragmentHomeBinding
import io.ak1.bubbletabbarapp.ui.adapter.MenuRecyclerViewAdapter

class HomeFragment : Fragment() {
    private lateinit var mBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.recyclerView.adapter =
            MenuRecyclerViewAdapter {
                findNavController().navigate(
                    when (it) {
                        0 -> R.id.action_homeFragment_to_viewPagerFragment
                        1 -> R.id.action_homeFragment_to_viewPager2Fragment
                        else -> R.id.action_homeFragment_to_navControllerFragment
                    },
                )
            }
    }
}
