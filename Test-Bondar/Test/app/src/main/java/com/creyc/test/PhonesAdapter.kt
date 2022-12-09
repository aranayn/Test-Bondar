package com.creyc.test

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class PhonesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mPhoneList: ArrayList<PhoneModel> = ArrayList()

    fun setupPhones(phonesList: Array<PhoneModel>) {
        mPhoneList.clear()
        mPhoneList.addAll(phonesList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is PhonesViewHolder){
            holder.bind(mPhones = mPhoneList[position])
        }
    }

    override fun getItemCount(): Int {
        return mPhoneList.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.recyclerview_item, parent, false)
        return PhonesViewHolder(itemView)
    }

    class PhonesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(mPhones: PhoneModel) {
            itemView.device_name.text = mPhones.name
            itemView.device_launch_price.text = mPhones.price
            itemView.device_launch_date.text = mPhones.date
            itemView.device_camera_score.text = mPhones.score
        }
    }
}