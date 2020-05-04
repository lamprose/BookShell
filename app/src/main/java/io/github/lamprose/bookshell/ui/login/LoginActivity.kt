package io.github.lamprose.bookshell.ui.login

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.BarUtils
import io.github.lamprose.bookshell.R
import io.github.lamprose.bookshell.app.base.BaseActivity
import io.github.lamprose.bookshell.databinding.ActivityLoginBinding
import io.github.lamprose.bookshell.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: BaseActivity<LoginViewModel, ActivityLoginBinding>() {


    override fun layoutId() = R.layout.activity_login

    override fun initView(savedInstanceState: Bundle?) {
        viewModel.result.observe(this, Observer {
            Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show()
            finish()
        })
        login.setOnClickListener {
            viewModel.login(username.text.toString(),password.text.toString())
        }
    }

    override fun initData() {

    }

}