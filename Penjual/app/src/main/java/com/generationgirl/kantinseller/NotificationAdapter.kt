package com.generationgirl.kantinseller

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @author by milhamj on 2019-10-16.
 */
class NotificationAdapter : RecyclerView.Adapter<NotificationAdapter.ViewHolder>(){

    private val list: MutableList<NotificationData> = arrayListOf()

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_notification, null))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setList(list: List<NotificationData>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private val title: TextView = v.findViewById(R.id.title)
        private val body: TextView = v.findViewById(R.id.body)

        fun bind(data: NotificationData) {
            title.text = data.title
            body.text = data.subtitle
        }
    }
}