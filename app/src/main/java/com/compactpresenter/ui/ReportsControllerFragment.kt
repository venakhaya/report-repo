package com.compactpresenter.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView

import com.compactpresenter.adapters.ExpandableListViewAdapter
import com.compactpresenter.R

import java.util.*

class ReportsControllerFragment : Fragment() {

    lateinit var expandableListView: ExpandableListView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.report_controller_layout,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        expandableListView = view.findViewById(R.id.expandableListView) as ExpandableListView
        val modelList = ArrayList<String>()
        modelList.add("Sales Report")
        modelList.add("Revenue Report")
        modelList.add("Turnover Report")
        modelList.add("Sales Forecast")
        expandableListView.setAdapter(ExpandableListViewAdapter(requireContext(),requireActivity(), modelList))
    }


}