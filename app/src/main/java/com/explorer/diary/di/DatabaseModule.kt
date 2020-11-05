package com.explorer.diary.di

import android.content.Context
import androidx.room.Room
import com.explorer.diary.config.Constant
import com.explorer.diary.data.AppDatabase
import com.explorer.diary.data.RecordDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * @author weixuefeng@lubangame.com
 * @version $
 * @time: 2020/11/5--1:33 PM
 * @description
 * @copyright (c) 2020 Newton Foundation. All rights reserved.
 */
@InstallIn(ApplicationComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun provideRecordDao(appDatabase: AppDatabase): RecordDao {
        return appDatabase.recordsDao()
    }

    @Singleton
    @Provides
    fun provideAppDataBase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, Constant.DATABASE_FILE_NAME).build()
    }
}