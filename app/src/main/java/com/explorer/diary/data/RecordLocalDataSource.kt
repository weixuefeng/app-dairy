package com.explorer.diary.data

import android.os.Handler
import android.os.Looper
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author weixuefeng@lubangame.com
 * @version $
 * @time: 2020/11/5--1:25 PM
 * @description
 * @copyright (c) 2020 Newton Foundation. All rights reserved.
 */
@Singleton
class RecordLocalDataSource @Inject constructor(private val recordDao: RecordDao): RecordDataSource {

    private val executorService: ExecutorService = Executors.newFixedThreadPool(4)

    private val mainThreadHandler by lazy {
        Handler(Looper.getMainLooper())
    }

    override fun addRecord(record: Record) {
        executorService
            .execute {
                recordDao.insertAll(record)
            }
    }

    override fun getAllRecords(callback: (List<Record>) -> Unit) {
        executorService
            .execute{
                val allRecords = recordDao.getAllRecords()
                mainThreadHandler
                    .post {
                        callback(allRecords)
                    }
            }
    }

    override fun removeRecords() {
        executorService
            .execute{
                recordDao.removeAllRecords()
            }
    }
}