package io.github.lamprose.bookshell.network.api

import io.github.lamprose.bookshell.app.base.BaseResult
import io.github.lamprose.bookshell.network.entity.BookInfoBean
import retrofit2.http.GET
import retrofit2.http.Path

interface BookService {

    @GET("/book/isbn/{isbn}")
    suspend fun getBookInfo(@Path("isbn") isbn:String):BaseResult<BookInfoBean>
}