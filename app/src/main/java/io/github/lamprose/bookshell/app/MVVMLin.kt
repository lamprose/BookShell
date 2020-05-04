package io.github.lamprose.bookshell.app

/**
 *   @auther : Aleyn
 *   time   : 2019/11/12
 */
object MVVMLin {

    private lateinit var mConfig: GlobalConfig

    fun install(config: GlobalConfig) {
        mConfig = config
    }

    fun getConfig() = mConfig

}