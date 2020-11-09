package com.explorer.diary.ui

import android.view.Gravity
import android.view.View
import androidx.fragment.app.activityViewModels
import com.explorer.diary.R
import com.explorer.diary.data.Record
import com.explorer.diary.navigator.AppNavigator
import com.explorer.diary.ui.popupwindow.SuccessPopupWindow
import com.explorer.diary.util.KeyboardUtils
import com.explorer.diary.util.SoftKeyBoardListener
import com.explorer.diary.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_edit_dairy.*
import me.jessyan.autosize.internal.CustomAdapt
import javax.inject.Inject

/**
 * @author weixuefeng@lubangame.com
 * @version $
 * @time: 2020/11/5--2:25 PM
 * @description
 * @copyright (c) 2020 Newton Foundation. All rights reserved.
 */
@AndroidEntryPoint
class EditDairyFragment : BaseFragment(), CustomAdapt {

    @Inject lateinit var navigator: AppNavigator

    private val viewModel by activityViewModels<HomeViewModel>()

    private var mCurrentRecord: Record? = null

    override fun getLayout(): Int = R.layout.fragment_edit_dairy


    override fun initViews() {
        mCurrentRecord = viewModel.getCurrentRecord()
        editText.setText(mCurrentRecord?.content)
        // save dairy logic
        quitButton.setOnClickListener {
            requireActivity().onBackPressed()
        }

        // add keyboard listener
        val softKeyBoardListener = SoftKeyBoardListener(rootView)
        softKeyBoardListener.setOnSoftKeyBoardChangeListener(onSoftKeyBoardChangeListener = object: SoftKeyBoardListener.OnSoftKeyBoardChangeListener {
            override fun keyBoardShow(height: Int) {
                showToolView()
            }

            override fun keyBoardHide(height: Int) {
                hideToolView()
            }
        })
        softKeyBoardListener.addGlobalLayoutListener()

        // complete button
        completeBt.setOnClickListener {
            val content = editText.text.toString()
            val record: Record = if (mCurrentRecord == null) {
                Record(content, System.currentTimeMillis())
            } else {
                mCurrentRecord!!.content = content
                mCurrentRecord!!
            }
            viewModel.addRecord(record)
            KeyboardUtils.hideKeyboard(editText)
            requireActivity().onBackPressed()
        }
    }


    private fun showToolView() {
        toolLayout.visibility = View.VISIBLE
    }

    private fun hideToolView() {
        toolLayout.visibility = View.GONE
    }

    private fun showConfirmPopupWindow() {
        val popupWindow = SuccessPopupWindow(mContext) {
            it.dismiss()
            requireActivity().onBackPressed()
        }
        popupWindow.showAtLocation(rootView, Gravity.BOTTOM or Gravity.CENTER, 0, 0)
    }


    override fun onResume() {
        super.onResume()
        val state = viewModel.getState()
        if(state != null) {
            editText.setText(state)
        }
        val recordState = viewModel.getRecordState()
        if(recordState != null) {
            mCurrentRecord = recordState
        }
    }

    override fun onPause() {
        super.onPause()
        viewModel.saveState(editText.text.toString())
        if(mCurrentRecord != null) {
            viewModel.saveRecord(mCurrentRecord!!)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clear()
    }

    override fun isBaseOnWidth(): Boolean = false

    override fun getSizeInDp(): Float = 720F
}