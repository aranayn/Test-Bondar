package com.creyc.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_1.view.*

class Fragment1 : Fragment() {
    private val myAdapter = PhonesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_1, container, false)

        loadData()
        root.RecyclerView.layoutManager = LinearLayoutManager(requireContext())
        root.RecyclerView.adapter = myAdapter

        return root
    }

    private fun loadData() {
        myAdapter.setupPhones(PhonesData.phonesArr)
    }


}