package io.github.lamprose.bookshell.app

import androidx.lifecycle.ViewModelProvider
import io.github.lamprose.bookshell.app.base.ViewModelFactory

/**
 *   @auther : Aleyn
 *   time   : 2019/11/12
 */
class GlobalConfig {
    var viewModelFactory: ViewModelProvider.NewInstanceFactory = ViewModelFactory()
}