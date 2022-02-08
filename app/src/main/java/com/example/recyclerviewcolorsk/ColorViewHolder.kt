package com.example.recyclerviewcolorsk

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast

class ColorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tv = itemView.findViewById<TextView>(R.id.color)

    init{
        tv.setOnClickListener { Toast.makeText(itemView.context, tv.text, Toast.LENGTH_SHORT).show();  }
    }

    fun bindTo(color: Int) {
        tv.setBackgroundColor(color)
        tv.text = itemView.context.getString(R.string.template, color)
    }
}
