package com.explorer.diary.ui

import com.explorer.diary.R
import com.explorer.diary.data.Record
import com.explorer.diary.data.RecordDataSource
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
class EditDairyFragment: BaseFragment() {

    @Inject lateinit var recordDataSource: RecordDataSource

    override fun getLayout(): Int = R.layout.fragment_edit_dairy

    override fun initViews() {
        saveButton.setOnClickListener {
            val toString = editText.text.toString()
            val record = Record(toString, System.currentTimeMillis())
            recordDataSource.addRecord(record)
        }
    }
}