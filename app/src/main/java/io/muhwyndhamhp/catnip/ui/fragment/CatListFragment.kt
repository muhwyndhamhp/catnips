package io.muhwyndhamhp.catnip.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import io.muhwyndhamhp.catnip.base.BaseFragment
import io.muhwyndhamhp.catnip.databinding.FragmentCatListBinding
import io.muhwyndhamhp.catnip.model.Cat
import io.muhwyndhamhp.catnip.ui.adapter.CatAdapter
import io.muhwyndhamhp.catnip.util.Constants.CAT_VIEW

class CatListFragment : BaseFragment() {

    lateinit var binding: FragmentCatListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCatListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        attachObserver()
    }

    private fun attachObserver() {
        baseViewModel.catList.observe(viewLifecycleOwner, {
            if (!it.isNullOrEmpty()) prepareRecyclerView(it)
        })
    }

    private fun prepareRecyclerView(catList: List<Cat>) {
        binding.rvList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = CatAdapter(
                CAT_VIEW,
                catList = catList
            ) { cat, position ->
                Navigation.findNavController(binding.root).navigate(CatListFragmentDirections.actionCatListFragmentToCatDetailActivity(cat))
            }
        }
    }
}