package io.muhwyndhamhp.catnip.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.muhwyndhamhp.catnip.base.BaseFragment
import io.muhwyndhamhp.catnip.databinding.FragmentUserBinding

class UserFragment : BaseFragment() {
    lateinit var binding: FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        baseViewModel.user.observe(viewLifecycleOwner, {
            if (it != null) binding.user = it
        })
    }
}