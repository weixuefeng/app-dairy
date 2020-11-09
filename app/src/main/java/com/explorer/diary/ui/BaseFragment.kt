package com.explorer.diary.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * @author weixuefeng@lubangame.com
 * @version $
 * @time: 2020/11/5--2:23 PM
 * @description
 * @copyright (c) 2020 Newton Foundation. All rights reserved.
 */

/**
 * Indicates whether the popup is showing above (the y coordinate of the popup's bottom
 * is less than the y coordinate of the anchor) or below the anchor view (the y coordinate
 * of the popup is greater than y coordinate of the anchor's bottom).
 *
 * The value returned
 * by this method is meaningful only after {@link #showAsDropDown(android.view.View)}
 * or {@link #showAsDropDown(android.view.View, int, int)} was invoked.
 *
 * @return True if this popup is showing above the anchor view, false otherwise.
 */
abstract class BaseFragment: Fragment() {

    lateinit var mContext: Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mContext = requireContext()
        return inflater.inflate(getLayout(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    abstract fun getLayout(): Int

    abstract fun initViews()

}