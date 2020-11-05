package com.explorer.diary.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.explorer.diary.config.Constant

/**
 * @author weixuefeng@lubangame.com
 * @version $
 * @time: 2020/11/5--11:43 AM
 * @description
 * @copyright (c) 2020 Newton Foundation. All rights reserved.
 */
@Entity(tableName = Constant.DATABASE_TABLE_RECORD)
data class Record(val content: String, val timeStamp: Long) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}