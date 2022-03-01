package com.example.modul5lesson2.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5lesson2.Model.Theme
import com.example.modul5lesson2.R

class ThemeAdapter(val themes : ArrayList<Theme>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var selected_index = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ThemeVH(LayoutInflater.from(parent.context).inflate(R.layout.item_theme, parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val theme = themes[position]

        if(holder is ThemeVH){
            holder.apply {
                borderLL.isSelected = theme.isSelected

                if(theme.isSelected) selected_index = position

                borderLL.setOnClickListener {
                    selected(position)
                }
            }
        }
    }

    fun selected(position: Int){
        themes[position].isSelected = true
        themes[selected_index].isSelected = false

        notifyItemChanged(position)
        notifyItemChanged(selected_index)
        selected_index = position
    }

    override fun getItemCount(): Int = themes.size

    class ThemeVH(view : View) : RecyclerView.ViewHolder(view){
        var borderLL = view.findViewById<LinearLayout>(R.id.ll_item)
    }
}