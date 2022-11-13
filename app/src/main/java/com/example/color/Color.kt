package com.example.color

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

data class Color(val value: Int)

class ColorsAdapter(
    private val colors: List<Color>
) : RecyclerView.Adapter<ColorsAdapter.ColorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.color_view, parent, false)
        return ColorViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.bind(colors[position])
    }

    override fun getItemCount() = colors.size

    class ColorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @RequiresApi(Build.VERSION_CODES.M)
        fun bind(color: Color) {
            itemView.setBackgroundColor(itemView.context.getColor(color.value))
        }
    }
}
