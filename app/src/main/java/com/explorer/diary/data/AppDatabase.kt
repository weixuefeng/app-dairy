package com.explorer.diary.data

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author weixuefeng@lubangame.com
 * @version $
 * @time: 2020/11/5--11:48 AM
 * @description
 * @copyright (c) 2020 Newton Foundation. All rights reserved.
 */
@Database(entities = [Record::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recordsDao(): RecordDao
}
