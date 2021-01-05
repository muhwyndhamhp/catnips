package io.muhwyndhamhp.catnip.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {
    val baseViewModel: BaseViewModel by activityViewModels()
}