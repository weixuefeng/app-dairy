package com.explorer.diary.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.explorer.diary.data.Record
import com.explorer.diary.data.RecordDataSource

/**
 * @author weixuefeng@lubangame.com
 * @version $
 * @time: 2020/11/5--6:14 PM
 * @description
 * @copyright (c) 2020 Newton Foundation. All rights reserved.
 */
open class HomeViewModel @ViewModelInject constructor(
    private val recordDataSource: RecordDataSource
): BaseViewModel() {

    fun saveRecord(msg: String) {
        val record = Record(msg, System.currentTimeMillis())
        recordDataSource.addRecord(record)
    }

    // query all records
    private val onAllRecords = MutableLiveData<List<Record>>()

    fun onAllRecords():LiveData<List<Record>> = onAllRecords

    fun getAllRecords() {
        recordDataSource
            .getAllRecords {
                onAllRecords.postValue(it)
            }
    }

    // on current record
    private val onCurrentRecord = MutableLiveData<Record>()

    fun onCurrentRecord(): LiveData<Record> = onCurrentRecord

    fun setCurrentRecord(record: Record) {
        onCurrentRecord.postValue(record)
    }

    fun getCurrentRecord(): Record? {
        return onCurrentRecord.value
    }
}

