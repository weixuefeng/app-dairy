package com.explorer.diary.ui.popupwindow

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import android.widget.TextView
import com.explorer.diary.R

/**
 * @author weixuefeng@lubangame.com
 * @version $
 * @time: 2020/11/6--2:42 PM
 * @description
 * @copyright (c) 2020 Newton Foundation. All rights reserved.
 */
class EditPopupWindow(context: Context): PopupWindow(context) {
    private val TAG = "EditPopupWindow"

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rootView = inflater.inflate(R.layout.popupwindow_edit, null)
        contentView = rootView

        width = ViewGroup.LayoutParams.MATCH_PARENT
        height = ViewGroup.LayoutParams.WRAP_CONTENT
        isFocusable = true
        isOutsideTouchable = true
        setBackgroundDrawable(null)
        animationStyle = R.style.pop_anim_style

        contentView.findViewById<Button>(R.id.button).setOnClickListener {
            Log.d(TAG, "CLICK")
        }
    }
}
