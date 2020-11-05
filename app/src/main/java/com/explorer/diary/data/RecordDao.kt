package com.explorer.diary.data

import androidx.room.*

/**
 * @author weixuefeng@lubangame.com
 * @version $
 * @time: 2020/11/5--11:49 AM
 * @description
 * @copyright (c) 2020 Newton Foundation. All rights reserved.
 */
@Dao
interface RecordDao {

    @Query("select * from records order by id desc")
    fun getAllRecords(): List<Record>

    @Insert(entity = Record::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg records: Record)

    @Query("select * from records where id = :id")
    fun selectRecordById(id: Long): Record

    @Query("delete from records")
    fun removeAllRecords()

}