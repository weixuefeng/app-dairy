package com.explorer.diary.di

import com.explorer.diary.navigator.AppNavigator
import com.explorer.diary.navigator.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * @author weixuefeng@lubangame.com
 * @version $
 * @time: 2020/11/4--9:04 PM
 * @description
 * @copyright (c) 2020 Newton Foundation. All rights reserved.
 */
@InstallIn(ActivityComponent::class)
@Module
abstract class NavigationModule {

    @Binds
    abstract fun bindNavigator(impl: AppNavigatorImpl): AppNavigator
}