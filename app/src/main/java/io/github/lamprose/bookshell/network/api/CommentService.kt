package io.github.lamprose.bookshell.network.api

import io.github.lamprose.bookshell.app.base.BaseResult
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface CommentService {

    /**
     * 发表评论
     */
    @POST("comment/post")
    suspend fun postComment(@Body body: RequestBody): BaseResult<Boolean>
}