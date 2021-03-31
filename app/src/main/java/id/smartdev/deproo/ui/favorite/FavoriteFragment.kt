package id.smartdev.deproo.ui.favorite

import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import id.smartdev.deproo.R
import id.smartdev.deproo.base.BaseFragment
import id.smartdev.deproo.databinding.FragmentFavoriteBinding

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding, ViewModel>() {
    override fun getViewModelBindingVariable(): Int = NO_VIEW_MODEL_BINDING_VARIABLE

    override fun getLayoutId(): Int = R.layout.fragment_favorite

    override fun init() {
        setHasOptionsMenu(true)
    }
}