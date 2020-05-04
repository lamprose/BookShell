package io.github.lamprose.bookshell.ui.main.home

import android.content.Intent
import android.widget.ImageView
import com.blankj.utilcode.util.ActivityUtils.startActivity
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import io.github.lamprose.bookshell.R
import io.github.lamprose.bookshell.network.entity.HandwritingBean
import io.github.lamprose.bookshell.ui.handwriting.HandwritingActivity
import io.github.lamprose.bookshell.utils.UIUtils.context

/**
 * desc: 笔迹列表适配器
 * author: lamprose
 * created: 2020/5/3 15:18
 */
class HomeListAdapter(authorVisible: Boolean=true,imageVisible:Boolean=true,titleVisible:Boolean=true) : BaseQuickAdapter<HandwritingBean, BaseViewHolder>(R.layout.item_article_list) {

    private val auVisible=authorVisible
    private val imVisible=imageVisible
    private val tiVisible=titleVisible

    override fun convert(helper: BaseViewHolder?, item: HandwritingBean?) {
        with(helper!!) {
            setText(R.id.tv_project_list_atticle_type, item!!.title)
            setText(R.id.tv_project_list_atticle_title, item.content)
            setText(R.id.tv_project_list_atticle_time, item.time?.substring(0,16))
            setText(R.id.tv_project_list_atticle_auther, item.userName)
            setVisible(R.id.tv_project_list_atticle_auther,auVisible)
            setVisible(R.id.iv_project_list_atticle_ic,imVisible)
            setVisible(R.id.tv_project_list_atticle_type,tiVisible)
            val imageView = helper.getView<ImageView>(R.id.iv_project_list_atticle_ic)
            if (!item.cover_img.isNullOrEmpty()) {
                Glide.with(imageView).load(item.cover_img).into(imageView)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        super.onBindViewHolder(holder,position)
        holder.itemView.setOnClickListener{
            val item = getItem(position)
            val intent = Intent(context, HandwritingActivity::class.java)
            intent.putExtra("id", item?.id)
            startActivity(intent)
        }
    }

}