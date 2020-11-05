package com.explorer.diary.ui

import androidx.recyclerview.widget.LinearLayoutManager
import com.explorer.diary.R
import com.explorer.diary.data.RecordDataSource
import com.explorer.diary.navigator.AppNavigator
import com.explorer.diary.navigator.Screens
import com.explorer.diary.ui.adapter.RecordAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

/**
 * @author weixuefeng@lubangame.com
 * @version $
 * @time: 2020/11/5--2:25 PM
 * @description
 * @copyright (c) 2020 Newton Foundation. All rights reserved.
 */
@AndroidEntryPoint
class HomeFragment: BaseFragment() {

    @Inject lateinit var recordDataSource: RecordDataSource
    @Inject lateinit var navigator: AppNavigator

    val adapter = RecordAdapter()

    override fun getLayout(): Int = R.layout.fragment_home

    override fun initViews() {
        recyclerView.layoutManager = LinearLayoutManager(mContext)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener { adapter, view, position ->

        }
        editTextView.setOnClickListener {
            navigator.navigateTo(Screens.EDIT)
        }
    }

    override fun onResume() {
        super.onResume()
        recordDataSource.getAllRecords {
            adapter.setNewInstance(it.toMutableList())
        }
    }
}