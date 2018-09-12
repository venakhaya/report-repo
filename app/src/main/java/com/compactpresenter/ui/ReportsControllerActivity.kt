package com.compactpresenter.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ExpandableListView

import com.compactpresenter.adapters.ExpandableListViewAdapter
import com.compactpresenter.R

import java.util.*

class ReportsControllerActivity : AppCompatActivity() {

    lateinit var expandableListView: ExpandableListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.report_controller_layout)
        expandableListView = findViewById(R.id.expandableListView) as ExpandableListView

        val modelList = ArrayList<String>()
        modelList.add("Annual Sales Report")
        modelList.add("Production Report")
        modelList.add("Marketing Visibility Report")
        modelList.add("Future Sales Forecast")
        expandableListView.setAdapter(ExpandableListViewAdapter(this,this@ReportsControllerActivity, modelList))
    }


}