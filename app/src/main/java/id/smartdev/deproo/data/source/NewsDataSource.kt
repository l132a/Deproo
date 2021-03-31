package id.smartdev.deproo.data.source

//class NewsDataSource @Inject constructor(apiService: ApiService) : PagingSource<Int, Article>() {
//    private val api = apiService
//    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
//        return null
//    }
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
//        val page = params.key ?: AppConstant.STARTING_PAGE_INDEX
//        return try {
//            val response = api.getNews("properti", "id", params.loadSize, page, BuildConfig.API_KEY)
//            val article = response.article
//            LoadResult.Page(
//                data = article,
//                prevKey = if (page == AppConstant.STARTING_PAGE_INDEX) null else page - 1,
//                nextKey = if (response.totalResult!! <= params.loadSize * page) null else page + 1
//            )
//        } catch (e: IOException) {
//            val error = IOException("Please Check Internet Connection")
//            LoadResult.Error(error)
//        } catch (e: HttpException) {
//            LoadResult.Error(e)
//        }
//    }
//}