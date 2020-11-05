package com.explorer.diary.data

/**
 * @author weixuefeng@lubangame.com
 * @version $
 * @time: 2020/11/5--12:02 PM
 * @description
 * @copyright (c) 2020 Newton Foundation. All rights reserved.
 */
interface RecordDataSource {
    fun addRecord(record: Record)
    fun getAllRecords(callback: (List<Record>) -> Unit)
    fun removeRecords()
}