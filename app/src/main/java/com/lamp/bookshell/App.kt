package com.lamp.bookshell

import android.app.Application
import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        QMUISwipeBackActivityManager.init(this)
    }
}