package com.explorer.diary.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.explorer.diary.R
import com.explorer.diary.data.Record

/**
 * @author weixuefeng@lubangame.com
 * @version $
 * @time: 2020/11/5--5:49 PM
 * @description
 * @copyright (c) 2020 Newton Foundation. All rights reserved.
 */
class RecordAdapter: BaseQuickAdapter<Record, BaseViewHolder>(
    layoutResId = R.layout.item_record
) {
    override fun convert(holder: BaseViewHolder, item: Record) {
        holder.setText(R.id.titleTextView, item.timeStamp.toString())
            .setText(R.id.contentTextView, item.content)
    }
}