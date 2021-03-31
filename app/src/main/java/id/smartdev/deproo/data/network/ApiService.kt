package id.smartdev.deproo.data.network

import id.smartdev.deproo.data.response.ResponseNews
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("everything")
    fun getNews(
        @Query("q") q: String?,
        @Query("language") language: String?,
        @Query("pageSize") pageSize: Int?,
        @Query("page") page: Int?,
        @Query("apiKey") apiKey: String?
    ): Observable<ResponseNews>
}