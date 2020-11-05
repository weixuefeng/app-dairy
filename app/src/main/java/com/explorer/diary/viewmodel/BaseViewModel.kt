package com.explorer.diary.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author weixuefeng@lubangame.com
 * @version $
 * @time: 2020/11/5--6:17 PM
 * @description
 * @copyright (c) 2020 Newton Foundation. All rights reserved.
 */
open class BaseViewModel: ViewModel() {

    private val onCommonError = MutableLiveData<Throwable>()

    fun onCommonError() = onCommonError

    private val onProgress = MutableLiveData<Boolean>()

    fun onProgress() = onProgress
}