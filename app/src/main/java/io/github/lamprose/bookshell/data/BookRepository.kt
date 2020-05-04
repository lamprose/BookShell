package io.github.lamprose.bookshell.data

import com.google.gson.Gson
import io.github.lamprose.bookshell.app.base.BaseModel
import io.github.lamprose.bookshell.constants.Constants
import io.github.lamprose.bookshell.data.http.BookNetWork
import io.github.lamprose.bookshell.data.http.HandwritingNetWork
import io.github.lamprose.bookshell.data.http.UserNetWork
import io.github.lamprose.bookshell.network.entity.BookInfoBean
import io.github.lamprose.bookshell.network.entity.HandwritingBean
import io.github.lamprose.bookshell.network.entity.UserBean
import io.github.lamprose.bookshell.utils.AppManager
import io.github.lamprose.bookshell.utils.PrefUtils
import okhttp3.FormBody
import okhttp3.MediaType
import okhttp3.RequestBody

class BookRepository private constructor(
    private val netWork: BookNetWork
): BaseModel(){
    suspend fun getBookInfo(isbn:String):BookInfoBean{
        return netCall {
            netWork.getBookInfo(isbn)
        }
    }

    companion object {

        @Volatile
        private var INSTANCE: BookRepository? = null

        fun getInstance(netWork: BookNetWork) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: BookRepository(netWork).also { INSTANCE = it }
            }
    }
}