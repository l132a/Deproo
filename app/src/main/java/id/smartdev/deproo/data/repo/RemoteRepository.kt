package id.smartdev.deproo.data.repo

import id.smartdev.deproo.BuildConfig
import id.smartdev.deproo.data.network.ApiService
import id.smartdev.deproo.data.response.ResponseNews
import io.reactivex.Observable
import javax.inject.Inject

class RemoteRepository @Inject constructor(apiService: ApiService) {
    private val api = apiService
    fun getArticle(
        d: String?,
        language: String?,
        pageSize: Int?,
        page: Int?
    ): Observable<ResponseNews> {
        return api.getNews(d, language, pageSize, page, BuildConfig.API_KEY)
    }
}