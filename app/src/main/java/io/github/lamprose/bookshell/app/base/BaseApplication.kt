package io.github.lamprose.bookshell.app.base

import android.app.Application
import android.content.Context
import io.github.lamprose.bookshell.app.GlobalConfig
import io.github.lamprose.bookshell.app.MVVMLin

/**
 *   @auther : Aleyn
 *   time   : 2019/11/12
 */
open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        baseApplication = this
    }

    companion object{
        private var baseApplication: BaseApplication? = null

        fun getContext(): Context {
            return baseApplication!!
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MVVMLin.install(GlobalConfig().apply {
            viewModelFactory =
                ViewModelFactory()
        })
    }
}