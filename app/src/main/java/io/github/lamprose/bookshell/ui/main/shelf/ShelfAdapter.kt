package io.github.lamprose.bookshell.ui.main.shelf

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import io.github.lamprose.bookshell.R
import io.github.lamprose.bookshell.network.entity.BookBean
import io.github.lamprose.bookshell.network.entity.BookInfoBean
import io.github.lamprose.bookshell.utils.UIUtils
import kotlinx.android.synthetic.main.item_book_list.view.*


class ShelfAdapter(var mContext: Context) : BaseAdapter() {

    var mList= emptyList<BookBean>()

    public fun setNewData(list:List<BookBean>){
        mList=list
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {
        var view: View? =p1
        if(p1==null && mList.isNotEmpty()){
            view=LayoutInflater.from(mContext).inflate(R.layout.item_book_list,null)
            var columns:Int=0
            var gridviewWidth:Int=0
            when(mList.size){
                in 1..12->{
                    columns=4
                    gridviewWidth=UIUtils.getDisplayWidth(mContext)-106
                }
                else -> {
                    val density = UIUtils.getDensity()
                    columns=mList.size/3+1
                    gridviewWidth = ((columns * 100-31) * density).toInt()
                }
            }
            (p2 as GridView).layoutParams.width = gridviewWidth // 设置GirdView布局参数,横向布局的关键
            (p2 as GridView).stretchMode = GridView.NO_STRETCH
            (p2 as GridView).numColumns = columns // 设置列数量=列表集合数
//            Glide.with(view.book_img).asBitmap().load(mList[p0].img).into(view.book_img)
            view.book_name.setText(mList[p0].name)
        }
        return view
    }


    override fun getItem(p0: Int): Any {
        return mList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return mList[p0].id
    }

    override fun getCount(): Int {
        return mList.size
    }

}