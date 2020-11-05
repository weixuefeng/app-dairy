package com.explorer.diary.ui

import android.util.Log
import androidx.fragment.app.activityViewModels
import com.explorer.diary.R
import com.explorer.diary.data.Record
import com.explorer.diary.navigator.AppNavigator
import com.explorer.diary.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_edit_dairy.*
import javax.inject.Inject

/**
 * @author weixuefeng@lubangame.com
 * @version $
 * @time: 2020/11/5--2:25 PM
 * @description
 * @copyright (c) 2020 Newton Foundation. All rights reserved.
 */
@AndroidEntryPoint
class EditDairyFragment : BaseFragment() {

    @Inject lateinit var navigator: AppNavigator

    private val viewModel by activityViewModels<HomeViewModel>()

    private var mCurrentRecord: Record? = null

    override fun getLayout(): Int = R.layout.fragment_edit_dairy


    override fun initViews() {
        mCurrentRecord = viewModel.getCurrentRecord()

        editText.setText(mCurrentRecord?.content)

        saveButton.setOnClickListener {
            val content = editText.text.toString()
            val record: Record = if (mCurrentRecord == null) {
                Record(content, System.currentTimeMillis())
            } else {
                mCurrentRecord!!.content = content
                mCurrentRecord!!
            }
            viewModel.addRecord(record)
            requireActivity().onBackPressed()
        }
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

    val TAG = "EditDairyFragment"
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "Destory")
        viewModel.clear()
    }
}