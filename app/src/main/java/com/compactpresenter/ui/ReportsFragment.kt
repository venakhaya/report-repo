package com.compactpresenter.ui

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.compactpresenter.R

class ReportsFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return  return inflater!!.inflate(R.layout.category_layout,container,false)
    }
}