package id.smartdev.deproo.ui.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import id.smartdev.deproo.R
import id.smartdev.deproo.databinding.FragmentHomeBinding
import id.smartdev.deproo.base.BaseFragment

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, ViewModel>() {
    override fun getViewModelBindingVariable(): Int = NO_VIEW_MODEL_BINDING_VARIABLE

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun init() {
        setHasOptionsMenu(true)
    }
}