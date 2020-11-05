package com.explorer.diary.ui

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.explorer.diary.R
import com.explorer.diary.data.Record
import com.explorer.diary.data.RecordDataSource
import com.explorer.diary.navigator.AppNavigator
import com.explorer.diary.navigator.Screens
import com.explorer.diary.ui.adapter.RecordAdapter
import com.explorer.diary.viewmodel.HomeViewModel
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

    @Inject lateinit var navigator: AppNavigator

    private val viewModel by activityViewModels<HomeViewModel>()


    override fun getLayout(): Int = R.layout.fragment_home

    override fun initViews() {
        viewModel.getAllRecords()

        val adapter = RecordAdapter()
        val recordsList = arrayListOf<Record>()
        recyclerView.layoutManager = LinearLayoutManager(mContext)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener { _, _, position ->
            viewModel.setCurrentRecord(recordsList[position])
            navigator.navigateTo(Screens.EDIT)
        }

        editTextView.setOnClickListener {
            navigator.navigateTo(Screens.EDIT)
        }

        viewModel.onAllRecords().observe(requireActivity(), Observer {
            recordsList.addAll(it.toMutableList())
            adapter.setNewInstance(it.toMutableList())
        })
    }


}