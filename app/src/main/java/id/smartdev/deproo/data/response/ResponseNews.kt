package id.smartdev.deproo.data.response

import id.smartdev.deproo.data.model.Article

data class ResponseNews(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)