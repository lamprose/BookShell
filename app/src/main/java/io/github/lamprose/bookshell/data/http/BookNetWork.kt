package io.github.lamprose.bookshell.data.http

import io.github.lamprose.bookshell.network.api.BookService
import io.github.lamprose.bookshell.utils.RetrofitClient

class BookNetWork {

    private val mService by lazy { RetrofitClient.getInstance().create(BookService::class.java) }

    suspend fun getBookInfo(isbn:String) = mService.getBookInfo(isbn)

    companion object {

        @Volatile
        private var netWork: BookNetWork? = null

        fun getInstance() = netWork ?: synchronized(this) {
            netWork ?: BookNetWork().also { netWork = it }
        }
    }
}