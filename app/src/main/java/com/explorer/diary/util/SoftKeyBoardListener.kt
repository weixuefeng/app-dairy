package com.explorer.diary.util

import android.graphics.Rect
import android.view.View
import android.view.ViewTreeObserver

class SoftKeyBoardListener(val rootView: View) {

    private var rootViewVisibleHeight: Int = 0//纪录根视图的显示高度
    private var onSoftKeyBoardChangeListener: OnSoftKeyBoardChangeListener? = null
    var globalLayoutListener: ViewTreeObserver.OnGlobalLayoutListener
    private var currentState = State.HIDE

    init {
        //监听视图树中全局布局发生改变或者视图树中的某个视图的可视状态发生改变
            globalLayoutListener = ViewTreeObserver.OnGlobalLayoutListener {
            //获取当前根视图在屏幕上显示的大小
            val r = Rect()
            rootView.getWindowVisibleDisplayFrame(r)

            val visibleHeight = r.height()

            if (rootViewVisibleHeight == 0) {
                rootViewVisibleHeight = visibleHeight
                return@OnGlobalLayoutListener
            }

            //根视图显示高度没有变化，可以看作软键盘显示／隐藏状态没有改变
            if (rootViewVisibleHeight == visibleHeight) {
                return@OnGlobalLayoutListener
            }
            //根视图显示高度变小超过200，可以看作软键盘显示了
            if (rootViewVisibleHeight - visibleHeight > 200) {
                if (onSoftKeyBoardChangeListener != null && currentState == State.HIDE) {
                    currentState = State.SHOW
                    onSoftKeyBoardChangeListener!!.keyBoardShow(rootViewVisibleHeight - visibleHeight)
                }
                rootViewVisibleHeight = visibleHeight
                return@OnGlobalLayoutListener
            }

            //根视图显示高度变大超过200，可以看作软键盘隐藏了
            if (visibleHeight - rootViewVisibleHeight > 200) {
                if (onSoftKeyBoardChangeListener != null && currentState == State.SHOW) {
                    currentState = State.HIDE
                    onSoftKeyBoardChangeListener!!.keyBoardHide(visibleHeight - rootViewVisibleHeight)
                }
                rootViewVisibleHeight = visibleHeight
                return@OnGlobalLayoutListener
            }
        }
        rootView.viewTreeObserver.addOnGlobalLayoutListener(globalLayoutListener)
    }

    fun setOnSoftKeyBoardChangeListener(onSoftKeyBoardChangeListener: OnSoftKeyBoardChangeListener) {
        this.onSoftKeyBoardChangeListener = onSoftKeyBoardChangeListener
    }

    fun addGlobalLayoutListener() {
        rootView.viewTreeObserver.addOnGlobalLayoutListener(globalLayoutListener)
    }

    fun removeGlobalLayoutListener() {
        rootView.viewTreeObserver.removeOnGlobalLayoutListener(globalLayoutListener)
    }

    interface OnSoftKeyBoardChangeListener {

        fun keyBoardShow(height: Int)

        fun keyBoardHide(height: Int)
    }

    enum class State{
        SHOW,
        HIDE
    }
}
