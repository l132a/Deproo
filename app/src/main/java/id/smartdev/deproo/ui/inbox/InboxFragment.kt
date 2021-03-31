package id.smartdev.deproo.ui.inbox

import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import id.smartdev.deproo.R
import id.smartdev.deproo.base.BaseFragment
import id.smartdev.deproo.databinding.FragmentInboxBinding

@AndroidEntryPoint
class InboxFragment : BaseFragment<FragmentInboxBinding, ViewModel>() {
    override fun getViewModelBindingVariable(): Int = NO_VIEW_MODEL_BINDING_VARIABLE

    override fun getLayoutId(): Int = R.layout.fragment_inbox

    override fun init() {
        setHasOptionsMenu(true)
    }
}