package com.explorer.diary.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.explorer.diary.R
import com.explorer.diary.data.Record
import com.explorer.diary.data.RecordDataSource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var recordDataSource: RecordDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveButton.setOnClickListener {
            val info = editText.text.toString()
            val record = Record(info, System.currentTimeMillis())
            recordDataSource.addRecord(record)
        }
    }


}