package io.github.lamprose.bookshell.utils

import android.content.Context
import io.github.lamprose.bookshell.app.base.BaseApplication

/**
 * @author zs
 * @date 2020-03-09
 */
object UIUtils {

    val context: Context get() = BaseApplication.getContext()

    fun dp2px(context: Context, dpValue: Float): Int {
        val density = context.resources.displayMetrics.density
        return (dpValue * density + 0.5).toInt()
    }

    fun dp2px(context: Context, dpValue: Int): Int {
        val density = context.resources.displayMetrics.density
        return (dpValue * density + 0.5).toInt()
    }

    fun getDensity():Float = context.resources.displayMetrics.density

    /**
     * sp转px
     *
     * @param context
     * @return
     */
    fun sp2px(context: Context, spVal: Float): Int {
//        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal, context.getResources()
//                .getDisplayMetrics());
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (spVal * fontScale + 0.5f).toInt()
    }

    /**
     * px转dp
     *
     * @param context
     * @param pxVal
     * @return
     */
    fun px2dp(context: Context, pxVal: Float): Float {
        val scale = context.resources.displayMetrics.density
        return pxVal / scale
    }

    /**
     * px转sp
     *
     * @param pxVal
     * @return
     */
    fun px2sp(context: Context, pxVal: Float): Float {
        return pxVal / context.resources.displayMetrics.scaledDensity
    }

    /**
     * 得到屏幕宽度
     *
     * @param context
     * @return
     */
    fun getDisplayWidth(context: Context): Int {
        return context.resources.displayMetrics.widthPixels
    }

    /**
     * 得到屏幕高度
     *
     * @param context
     * @return
     */
    fun getDisplayHeight(context: Context): Int {
        return context.resources.displayMetrics.heightPixels
    }
}
