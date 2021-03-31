package id.smartdev.deproo.ui.news

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.smartdev.deproo.data.repo.RemoteRepository
import id.smartdev.deproo.data.response.ResponseNews
import io.reactivex.Observable
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repo: RemoteRepository) : ViewModel() {

    fun getArticle(
        d: String?,
        language: String,
        pageSize: Int?,
        page: Int?
    ): Observable<ResponseNews> {
        return repo.getArticle(d, language, pageSize, page)
    }
}