package id.smartdev.deproo.ui.news

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import com.ethanhua.skeleton.Skeleton
import com.ethanhua.skeleton.SkeletonScreen
import dagger.hilt.android.AndroidEntryPoint
import id.smartdev.deproo.R
import id.smartdev.deproo.data.model.Article
import id.smartdev.deproo.databinding.FragmentNewsBinding
import id.smartdev.deproo.base.BaseFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding, NewsViewModel>() {

    private lateinit var skeletonScreen: SkeletonScreen
    private lateinit var adapter: NewsAdapter
    private var listArticle: ArrayList<Article> = ArrayList()
    private val viewModel: NewsViewModel by viewModels()

    override fun getViewModelBindingVariable(): Int = NO_VIEW_MODEL_BINDING_VARIABLE

    override fun getLayoutId(): Int = R.layout.fragment_news

    override fun init() {
        setHasOptionsMenu(true)

        adapter = NewsAdapter(listArticle) {

        }

        skeletonScreen = Skeleton.bind(getDataBinding().rvNews)
            .adapter(adapter)
            .color(R.color.light_transparent)
            .load(R.layout.item_news)
            .show()

        try {
            loadData()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        getDataBinding().slNews.setOnRefreshListener {
            loadData()
        }
    }

    @SuppressLint("CheckResult")
    private fun loadData() {
        listArticle.clear()
        viewModel.getArticle("properti", "id", 10, 1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { res ->
                    listArticle.addAll(res.articles)
                },
                { t ->
                    t.printStackTrace()
                }, {
                    skeletonScreen.hide()
                    getDataBinding().slNews.isRefreshing = false
                    adapter.notifyDataSetChanged()
                }
            )
    }
}