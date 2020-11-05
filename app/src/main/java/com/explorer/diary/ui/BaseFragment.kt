package com.explorer.diary.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * @author weixuefeng@lubangame.com
 * @version $
 * @time: 2020/11/5--2:23 PM
 * @description
 * @copyright (c) 2020 Newton Foundation. All rights reserved.
 */
abstract class BaseFragment: Fragment() {

    lateinit var mContext: Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mContext = context!!
        return inflater.inflate(getLayout(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    abstract fun getLayout(): Int

    abstract fun initViews()

}