package com.explorer.diary.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.explorer.diary.data.Record
import com.explorer.diary.data.RecordDataSource
import java.util.logging.Logger

/**
 * @author weixuefeng@lubangame.com
 * @version $
 * @time: 2020/11/5--6:14 PM
 * @description
 * @copyright (c) 2020 Newton Foundation. All rights reserved.
 */
open class HomeViewModel @ViewModelInject constructor(
    private val recordDataSource: RecordDataSource,
    @Assisted private val savedStateHandle: SavedStateHandle
): BaseViewModel() {

    private val key = "key"
    private val recordKey = "recordKey"

    fun addRecord(record: Record) {
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

    // save current state
    fun saveState(info: String) {
        savedStateHandle.set(key, info)
    }

    fun getState():String? {
        return savedStateHandle.getLiveData<String>(key).value
    }

    fun saveRecord(info: Record) {
        savedStateHandle.set(recordKey, info)
    }

    fun getRecordState(): Record? {
        return savedStateHandle.getLiveData<Record>(recordKey).value
    }

    val TAG = "HomeViewModel"
    override fun onCleared() {
        savedStateHandle.remove<String>(key)
        savedStateHandle.remove<String>(recordKey)
    }

    fun clear() {
        onCleared()
    }
}

