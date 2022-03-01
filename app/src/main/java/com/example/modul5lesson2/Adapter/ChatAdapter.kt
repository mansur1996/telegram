package com.example.modul5lesson2.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5lesson2.Model.Chat
import com.example.modul5lesson2.R

class ChatAdapter(var context: Context, var items : ArrayList<Chat>)
    :RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return MessageViewHOlder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if(holder is MessageViewHOlder){
            holder.apply {
                iv_profile.setImageResource(item.profile)
                tv_fulname.text = item.fullname
                tv_message.text = item.message
            }
        }
    }

    override fun getItemCount(): Int = items.size

    class MessageViewHOlder(val view : View):RecyclerView.ViewHolder(view){
        var iv_profile = view.findViewById<ImageView>(R.id.iv_profile)
        var tv_fulname = view.findViewById<TextView>(R.id.tv_fullname)
        var tv_message = view.findViewById<TextView>(R.id.tv_message)
    }
}