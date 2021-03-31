package id.smartdev.deproo.ui.account

import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import id.smartdev.deproo.R
import id.smartdev.deproo.base.BaseFragment
import id.smartdev.deproo.databinding.FragmentProfileBinding

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding, ViewModel>() {
    override fun getViewModelBindingVariable(): Int = NO_VIEW_MODEL_BINDING_VARIABLE

    override fun getLayoutId(): Int = R.layout.fragment_sign_in

    override fun init() {
        setHasOptionsMenu(true)
    }
}