package com.compactpresenter.adapters

import android.content.Context
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.compactpresenter.R
import com.compactpresenter.graphs.PieChartFragment


class ExpandableListViewAdapter(private val context: Context, private val activity: AppCompatActivity, private val listGroup: List<String>) : BaseExpandableListAdapter() {

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
            convertView = groupInflater.inflate(R.layout.group_layout, null)
        }

        if (convertView != null) {
            var textE = convertView.findViewById(R.id.text1) as TextView
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
                    convertView = childInflater.inflate(R.layout.item_widgets, null)
                    //Add fragments to view
                }
                1 -> {
                    convertView = childInflater.inflate(R.layout.item_text, null)
                }
                2 -> {
                    convertView = childInflater.inflate(R.layout.item_layouts, null)
                }
                3 -> {
                    convertView = childInflater.inflate(R.layout.graph_holder, null)
                    commitFragment(convertView, R.id.graph_holder_layout)
                }
            }
        }
        return convertView as View
    }

    fun commitFragment(view: View, id: Int) {

        val uiHandler = Handler()
        uiHandler.post {
            (activity).supportFragmentManager.beginTransaction().replace(id,
                    PieChartFragment()).commitNow()
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