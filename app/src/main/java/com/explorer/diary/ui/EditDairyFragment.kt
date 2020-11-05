package com.explorer.diary.ui

import androidx.fragment.app.activityViewModels
import com.explorer.diary.R
import com.explorer.diary.data.Record
import com.explorer.diary.data.RecordDataSource
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

    @Inject
    lateinit var recordDataSource: RecordDataSource

    private val viewModel by activityViewModels<HomeViewModel>()

    override fun getLayout(): Int = R.layout.fragment_edit_dairy


    override fun initViews() {
        val currentRecord = viewModel.getCurrentRecord()

        editText.setText(currentRecord?.content)

        saveButton.setOnClickListener {
            val content = editText.text.toString()
            val record: Record = if (currentRecord == null) {
                Record(content, System.currentTimeMillis())
            } else {
                currentRecord.content = content
                currentRecord
            }
            recordDataSource.addRecord(record)
        }

    }


}