package com.explorer.diary.di

import com.explorer.diary.data.RecordDataSource
import com.explorer.diary.data.RecordLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * @author weixuefeng@lubangame.com
 * @version $
 * @time: 2020/11/5--1:49 PM
 * @description
 * @copyright (c) 2020 Newton Foundation. All rights reserved.
 */
@InstallIn(ApplicationComponent::class)
@Module
abstract class RecordModule {

    @Binds
    @Singleton
    abstract fun bindDatabaseRecords(impl: RecordLocalDataSource): RecordDataSource
}