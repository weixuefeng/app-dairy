package com.explorer.diary.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * @author weixuefeng@lubangame.com
 * @version $
 * @time: 2020/11/5--11:56 PM
 * @description
 * @copyright (c) 2020 Newton Foundation. All rights reserved.
 */
object DateUtils {

    private val formatter = SimpleDateFormat("yyyy年MM月dd日 E", Locale.SIMPLIFIED_CHINESE)

    fun formatDate(timestamp: Long): String {
        return formatter.format(Date(timestamp)).replace("周", "星期")
    }
}