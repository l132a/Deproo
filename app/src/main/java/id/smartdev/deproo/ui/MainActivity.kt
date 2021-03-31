package id.smartdev.deproo.ui

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import id.smartdev.deproo.R
import id.smartdev.deproo.databinding.ActivityMainBinding
import id.smartdev.deproo.ui.home.HomeFragment
import id.smartdev.deproo.ui.news.NewsFragment
import id.smartdev.deproo.base.BaseActivity
import id.smartdev.deproo.ui.account.SignInFragment
import id.smartdev.deproo.ui.favorite.FavoriteFragment
import id.smartdev.deproo.ui.inbox.InboxFragment

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, ViewModel>() {

    override fun getViewModelBindingVariable(): Int = NO_VIEW_MODEL_BINDING_VARIABLE

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun init() {
        getDataBinding().navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                }
                R.id.nav_news -> {
                    loadFragment(NewsFragment())
                }
                R.id.nav_inbox -> {
                    loadFragment(InboxFragment())
                }
                R.id.nav_favorite -> {
                    loadFragment(FavoriteFragment())
                }
                R.id.nav_account -> {
                    loadFragment(SignInFragment())
                }
            }
            true
        }
        getDataBinding().navView.selectedItemId = R.id.nav_home
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_container, fragment)
            .commit()
    }
}