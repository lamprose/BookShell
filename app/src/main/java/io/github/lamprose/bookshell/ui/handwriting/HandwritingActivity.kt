package io.github.lamprose.bookshell.ui.handwriting

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import io.github.lamprose.bookshell.R
import io.github.lamprose.bookshell.app.base.BaseActivity
import io.github.lamprose.bookshell.databinding.ActivityHandwritingBinding
import io.github.lamprose.bookshell.ui.book.BookActivity
import io.github.lamprose.bookshell.ui.user.UserActivity
import io.github.lamprose.bookshell.widget.InputTextMsgDialog
import kotlinx.android.synthetic.main.activity_handwriting.*

class HandwritingActivity : BaseActivity<HandwritingViewModel, ActivityHandwritingBinding>() {

    override fun layoutId() = R.layout.activity_handwriting

    private var bookId:Int=0


    override fun initData() {
        intent.getIntExtra("id",0).let {
            viewModel.getData(it)
            bookId=it
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        viewModel.handwritingDetail.observe(this, Observer {
            mBinding!!.handwriting=it
        })
        handwriting_comment_text.setOnClickListener {
            val commentDialog=InputTextMsgDialog(this,R.style.dialog_center)
            commentDialog.setmOnTextSendListener {
                Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
            }
            commentDialog.show()
        }
        //给用户名绑定事件
        handwriting_user_name.setOnClickListener{
            val bundle=Bundle()
            bundle.putString("userName",(it as Button).text.toString())
            intent(bundle,UserActivity::class.java,true)
        }
        //书籍名绑定事件
        handwriting_book_title.setOnClickListener{
            val bundle=Bundle()
            bundle.putString("ISBN",viewModel.handwritingDetail.value?.ISBN)
            intent(bundle,BookActivity::class.java,false)
        }
    }
}
