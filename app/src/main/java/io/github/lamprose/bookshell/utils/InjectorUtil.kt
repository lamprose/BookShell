package io.github.lamprose.bookshell.utils

import io.github.lamprose.bookshell.data.BookRepository
import io.github.lamprose.bookshell.data.HandwritingRepository
import io.github.lamprose.bookshell.data.HomeRepository
import io.github.lamprose.bookshell.data.UserRepository
import io.github.lamprose.bookshell.data.db.LinDatabase
import io.github.lamprose.bookshell.data.http.BookNetWork
import io.github.lamprose.bookshell.data.http.HandwritingNetWork
import io.github.lamprose.bookshell.data.http.HomeNetWork
import io.github.lamprose.bookshell.data.http.UserNetWork

object InjectorUtil {

    fun getHomeRepository() = HomeRepository.getInstance(
        HomeNetWork.getInstance(),
        LinDatabase.getInstanse().homeLocaData()
    )

    fun getUserRepository() = UserRepository.getInstance(
        UserNetWork.getInstance()
    )

    fun getHandwritingRepository() = HandwritingRepository.getInstance(
        HandwritingNetWork.getInstance()
    )

    fun getBookRepository() = BookRepository.getInstance(
        BookNetWork.getInstance()
    )

}