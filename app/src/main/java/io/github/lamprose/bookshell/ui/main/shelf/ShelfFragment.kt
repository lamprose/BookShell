package io.github.lamprose.bookshell.ui.main.shelf

import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.GridView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import io.github.lamprose.bookshell.R
import io.github.lamprose.bookshell.app.base.BaseFragment
import io.github.lamprose.bookshell.network.entity.BookBean
import io.github.lamprose.bookshell.network.entity.BookInfoBean
import io.github.lamprose.bookshell.utils.UIUtils
import kotlinx.android.synthetic.main.shelf_fragment.*


class ShelfFragment:BaseFragment<ShelfViewModel,ViewDataBinding>() {

    private val mAdapter by lazy { ShelfAdapter(context!!) }

    override fun layoutId()= R.layout.shelf_fragment

    companion object {
        fun newInstance() = ShelfFragment()
    }

    override fun initView(savedInstanceState: Bundle?) {
        with(gv_shelf){
            adapter=mAdapter
        }
        var list:MutableList<BookBean> = ArrayList()

        for(i in 1..10){
            list.add(BookBean("name$i","12$i","img$i", i.toLong()))
        }
        mAdapter.setNewData(list)
    }

}