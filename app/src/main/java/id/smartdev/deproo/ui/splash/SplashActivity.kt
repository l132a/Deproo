package id.smartdev.deproo.ui.splash

import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import id.smartdev.deproo.R
import id.smartdev.deproo.databinding.ActivitySplashBinding
import id.smartdev.deproo.base.BaseActivity

@AndroidEntryPoint
class SplashActivity: BaseActivity<ActivitySplashBinding, ViewModel>() {
    override fun getViewModelBindingVariable(): Int = NO_VIEW_MODEL_BINDING_VARIABLE

    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun init() {

    }
}