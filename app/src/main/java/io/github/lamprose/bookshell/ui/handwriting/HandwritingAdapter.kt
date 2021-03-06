package io.github.lamprose.bookshell.ui.handwriting

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import io.github.lamprose.bookshell.R
import io.github.lamprose.bookshell.app.base.BaseDBViewHoder
import io.github.lamprose.bookshell.databinding.ActivityHandwritingBinding
import io.github.lamprose.bookshell.network.entity.HandwritingBean

class HandwritingAdapter :BaseQuickAdapter<HandwritingBean,BaseDBViewHoder<ActivityHandwritingBinding>>(R.layout.activity_handwriting){

    override fun convert(helper: BaseDBViewHoder<ActivityHandwritingBinding>, item: HandwritingBean?) {
        helper.getBinding().handwriting=item
        helper.getBinding().executePendingBindings()
    }

    override fun getItemView(layoutResId: Int, parent: ViewGroup?): View {
        val binding = DataBindingUtil
            .inflate<ActivityHandwritingBinding>(mLayoutInflater, layoutResId, parent, false)
            ?: return super.getItemView(layoutResId, parent)
        return binding.root.apply {
            setTag(R.id.BaseQuickAdapter_databinding_support, binding)
        }
    }

}