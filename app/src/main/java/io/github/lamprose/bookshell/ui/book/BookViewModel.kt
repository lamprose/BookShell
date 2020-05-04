package io.github.lamprose.bookshell.ui.book

import androidx.lifecycle.MutableLiveData
import io.github.lamprose.bookshell.app.base.BaseViewModel
import io.github.lamprose.bookshell.network.entity.BookInfoBean
import io.github.lamprose.bookshell.network.entity.HandwritingBean
import io.github.lamprose.bookshell.network.entity.HandwritingListBean
import io.github.lamprose.bookshell.utils.InjectorUtil

class BookViewModel :BaseViewModel(){

    private val bookRepository by lazy { InjectorUtil.getBookRepository() }
    private val handwritingRepository by lazy { InjectorUtil.getHandwritingRepository() }
    var bookDetail = MutableLiveData<BookInfoBean>()
    var handwritingListBean = MutableLiveData<HandwritingListBean>()

    fun getBookData(isbn:String):MutableLiveData<BookInfoBean>{
        launchGo({
            bookDetail.value = bookRepository.getBookInfo(isbn)
        },{
            if(defUI.toastEvent.value==""){
                defUI.toastEvent.postValue("获取成功")
                defUI.toastEvent.value=""

            }
        })
        return bookDetail
    }

    fun getHandwritingList(page:Int,isbn:String):MutableLiveData<HandwritingListBean>{
        launchGo({
            handwritingListBean.value=handwritingRepository.getHandwritingListByPageWithoutStore(page,isbn)
        })
        return handwritingListBean
    }

    fun postHandwriting(handwritingBean: HandwritingBean){
        launchGo({
            handwritingRepository.postHandwriting(handwritingBean)
        },{
            if(defUI.toastEvent.value==""){
                defUI.toastEvent.postValue("登录成功")
                defUI.toastEvent.value=""
            }
        })
    }
}