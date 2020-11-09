package com.explorer.diary.util

import android.util.Log
import com.explorer.diary.BuildConfig
import com.explorer.diary.ui.BaseActivity
import com.explorer.diary.ui.BaseFragment

/**
 * @author weixuefeng@lubangame.com
 * @version $
 * @time: 2020/11/9--5:44 PM
 * @description
 * @copyright (c) 2020 Newton Foundation. All rights reserved.
 */
const val LOG_PREFIX = "AppDairy-->"

fun BaseActivity.logDebug(msg: Any) {
    if(BuildConfig.DEBUG) {
        Log.d(LOG_PREFIX + this.javaClass.name, msg.toString())
    }
}

fun BaseFragment.logDebug(msg: Any) {
    if(BuildConfig.DEBUG) {
        Log.d(LOG_PREFIX + this.javaClass.name, msg.toString())
    }
}

fun BaseActivity.logError(msg: Any) {
    if(BuildConfig.DEBUG) {
        Log.e(LOG_PREFIX + this.javaClass.name, msg.toString())
    }
}

fun BaseFragment.logError(msg: Any) {
    if(BuildConfig.DEBUG) {
        Log.e(LOG_PREFIX + this.javaClass.name, msg.toString())
    }
}
