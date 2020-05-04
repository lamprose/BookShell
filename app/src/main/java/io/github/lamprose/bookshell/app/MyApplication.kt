package io.github.lamprose.bookshell.app

import com.blankj.utilcode.util.LogUtils
import io.github.lamprose.bookshell.BuildConfig
import io.github.lamprose.bookshell.app.base.BaseApplication

/**
 *   @auther : Aleyn
 *   time   : 2019/11/04
 */
class MyApplication : BaseApplication() {


    override fun onCreate() {
        super.onCreate()
        LogUtils.getConfig().run {
            isLogSwitch = BuildConfig.DEBUG
            setSingleTagSwitch(true)
        }

    }
}