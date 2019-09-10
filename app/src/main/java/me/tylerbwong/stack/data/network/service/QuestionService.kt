package me.tylerbwong.stack.data.network.service

import me.tylerbwong.stack.data.model.*
import me.tylerbwong.stack.data.network.ServiceProvider
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface QuestionService {

    @GET("questions")
    suspend fun getQuestions(
            @Query(SITE_PARAM) site: String = DEFAULT_SITE,
            @Query(SORT_PARAM) @Sort sort: String = DEFAULT_SORT,
            @Query(ORDER_PARAM) @Order order: String = DEFAULT_ORDER,
            @Query(PAGE_SIZE_PARAM) pageSize: Int = DEFAULT_PAGE_SIZE,
            @Query(PAGE_PARAM) page: Int = DEFAULT_PAGE,
            @Query(FILTER_PARAM) filter: String = DEFAULT_FILTER,
            @Query(KEY_PARAM) key: String = ServiceProvider.DEFAULT_KEY
    ): Response<Question>

    @GET("questions")
    suspend fun getQuestionsByTags(
            @Query(SITE_PARAM) site: String = DEFAULT_SITE,
            @Query(SORT_PARAM) @Sort sort: String = DEFAULT_SORT,
            @Query(ORDER_PARAM) @Order order: String = DEFAULT_ORDER,
            @Query(PAGE_SIZE_PARAM) pageSize: Int = DEFAULT_PAGE_SIZE,
            @Query(PAGE_PARAM) page: Int = DEFAULT_PAGE,
            @Query(FILTER_PARAM) filter: String = DEFAULT_FILTER,
            @Query(TAGGED_PARAM) tags: String,
            @Query(KEY_PARAM) key: String = ServiceProvider.DEFAULT_KEY
    ): Response<Question>

    @GET("questions/{id}")
    suspend fun getQuestionDetails(
            @Path("id") questionId: Int,
            @Query(SITE_PARAM) site: String = DEFAULT_SITE,
            @Query(FILTER_PARAM) filter: String = DETAIL_FILTER,
            @Query(KEY_PARAM) key: String = ServiceProvider.DEFAULT_KEY
    ): Response<Question>

    @GET("questions/{id}/linked")
    suspend fun getLinkedQuestions(
            @Path("id") questionId: Int,
            @Query(SITE_PARAM) site: String = DEFAULT_SITE,
            @Query(SORT_PARAM) @Sort sort: String = DEFAULT_SORT,
            @Query(ORDER_PARAM) @Order order: String = DEFAULT_ORDER,
            @Query(PAGE_SIZE_PARAM) pageSize: Int = DEFAULT_PAGE_SIZE,
            @Query(PAGE_PARAM) page: Int = DEFAULT_PAGE,
            @Query(FILTER_PARAM) filter: String = DEFAULT_FILTER,
            @Query(KEY_PARAM) key: String = ServiceProvider.DEFAULT_KEY
    ): Response<Question>

    @GET("questions/{id}/related")
    suspend fun getRelatedQuestions(
            @Path("id") questionId: Int,
            @Query(SITE_PARAM) site: String = DEFAULT_SITE,
            @Query(SORT_PARAM) @Sort sort: String = DEFAULT_SORT,
            @Query(ORDER_PARAM) @Order order: String = DEFAULT_ORDER,
            @Query(PAGE_SIZE_PARAM) pageSize: Int = DEFAULT_PAGE_SIZE,
            @Query(PAGE_PARAM) page: Int = DEFAULT_PAGE,
            @Query(FILTER_PARAM) filter: String = DEFAULT_FILTER,
            @Query(KEY_PARAM) key: String = ServiceProvider.DEFAULT_KEY
    ): Response<Question>

    @GET("questions/{id}/answers")
    suspend fun getQuestionAnswers(
            @Path("id") questionId: Int,
            @Query(SITE_PARAM) site: String = DEFAULT_SITE,
            @Query(ORDER_PARAM) @Order order: String = DEFAULT_ORDER,
            @Query(PAGE_SIZE_PARAM) pageSize: Int = DEFAULT_PAGE_SIZE,
            @Query(PAGE_PARAM) page: Int = DEFAULT_PAGE,
            @Query(FILTER_PARAM) filter: String = DETAIL_FILTER,
            @Query(KEY_PARAM) key: String = ServiceProvider.DEFAULT_KEY
    ): Response<Answer>

    @GET("/answers/{ids}/comments")
    suspend fun getQuestionComments(
            @Path("id") answerId: Int,
            @Query(ORDER_PARAM) @Order order: String = DEFAULT_ORDER,
            @Query(PAGE_SIZE_PARAM) pageSize: Int = DEFAULT_PAGE_SIZE,
            @Query(PAGE_PARAM) page: Int = DEFAULT_PAGE,
            @Query(FILTER_PARAM) filter: String = DETAIL_FILTER,
            @Query(KEY_PARAM) key: String = ServiceProvider.DEFAULT_KEY
    ): Response<Comment>

    @GET("search/advanced")
    suspend fun getQuestionsBySearchString(
            @Query(SITE_PARAM) site: String = DEFAULT_SITE,
            @Query(SORT_PARAM) @Sort sort: String = RELEVANCE,
            @Query(ORDER_PARAM) @Order order: String = DEFAULT_ORDER,
            @Query(PAGE_SIZE_PARAM) pageSize: Int = DEFAULT_PAGE_SIZE,
            @Query(PAGE_PARAM) page: Int = DEFAULT_PAGE,
            @Query(FILTER_PARAM) filter: String = DEFAULT_FILTER,
            @Query(KEY_PARAM) key: String = ServiceProvider.DEFAULT_KEY,
            @Query(SEARCH_PARAM) searchString: String
    ): Response<Question>

    companion object {
        internal const val DEFAULT_FILTER = "!-N4vhDh8TGjM*h(2reCz3exHc6q)hWsdi"
        internal const val DETAIL_FILTER = "!3r.zRmD4l6rHdTgXfBOo(qq6rg_D3I7uaTO)p123.RRrNwbbeBOKxJp8dch552I"
    }
}
