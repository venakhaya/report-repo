package com.compactpresenter.adapters

import android.content.Context
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.compactpresenter.R
import com.compactpresenter.graphs.PieChartFragment
import com.compactpresenter.ui.ReportsFragment


class ExpandableListViewAdapter(private val context: Context, private val activity: FragmentActivity, private val listGroup: List<String>) : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return listGroup.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return 1
    }

    override fun getGroup(groupPosition: Int): Any {
        return listGroup[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any? {
        return null
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            val groupInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = groupInflater.inflate(R.layout.sub_report_group_title_layout, null)
        }

        if (convertView != null) {
            var textE = convertView.findViewById(R.id.header_text_view) as TextView
            textE.text = getGroup(groupPosition) as String
        }

        return convertView as View
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            val childInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            val itemType = getChildType(groupPosition, childPosition)

            when (itemType) {
                0 -> {
                    convertView = childInflater.inflate(R.layout.master_report_layout, null)
                    //Add fragments to view
                    commitFragment(ReportsFragment(), R.id.report_fragment_container_layout)
                }
                1 -> {
                    convertView = childInflater.inflate(R.layout.master_report_layout, null)
                    commitFragment(ReportsFragment(), R.id.report_fragment_container_layout)
                }
                2 -> {
                    convertView = childInflater.inflate(R.layout.master_report_layout, null)
                    commitFragment(ReportsFragment(), R.id.report_fragment_container_layout)
                }
                3 -> {
                    convertView = childInflater.inflate(R.layout.graph_holder, null)
                    commitFragment(PieChartFragment(), R.id.graph_holder_layout)
                }
            }
        }
        return convertView as View
    }

    private fun commitFragment(fragment: Fragment, id: Int) {

        val uiHandler = Handler()
        uiHandler.post {
            (activity).supportFragmentManager.beginTransaction().replace(id,
                   fragment).commitNow()
        }
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return false
    }

    override fun getChildTypeCount(): Int {
        return 11
    }

    override fun getChildType(groupPosition: Int, childPosition: Int): Int {
        return groupPosition
    }

}