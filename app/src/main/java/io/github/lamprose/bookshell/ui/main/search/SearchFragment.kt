package io.github.lamprose.bookshell.ui.main.search

import androidx.databinding.ViewDataBinding
import io.github.lamprose.bookshell.R
import io.github.lamprose.bookshell.app.base.BaseFragment
import io.github.lamprose.bookshell.app.base.NoViewModel

class SearchFragment:BaseFragment<NoViewModel,ViewDataBinding>() {

    override fun layoutId()= R.layout.search_fragment

    companion object {
        fun newInstance() = SearchFragment()
    }
}