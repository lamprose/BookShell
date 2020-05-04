package io.github.lamprose.bookshell.ui.handwriting

import androidx.lifecycle.MutableLiveData
import io.github.lamprose.bookshell.app.base.BaseViewModel
import io.github.lamprose.bookshell.network.entity.HandwritingBean
import io.github.lamprose.bookshell.utils.InjectorUtil

class HandwritingViewModel:BaseViewModel(){

    private val handwritingRepository by lazy { InjectorUtil.getHandwritingRepository() }

    var handwritingDetail = MutableLiveData<HandwritingBean>()



    fun getData(id:Int):MutableLiveData<HandwritingBean>{
        launchGo({
            handwritingDetail.value = handwritingRepository.getHandwritingById(id)
        })
        return handwritingDetail
    }


}