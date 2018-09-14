package com.compactpresenter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.compactpresenter.R
import com.compactpresenter.ui.fragments.BaseReportFragment

class ReportsFragment : BaseReportFragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.category_layout,container,false)
    }
    override fun setViews() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}