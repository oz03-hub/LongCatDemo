package com.example.longcatdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(
    private val customList: List<BuildingData>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val imageView: ImageView = itemView.findViewById(R.id.apartmentIMG)
        val textView: TextView = itemView.findViewById(R.id.text_1)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition

            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.view_element, parent, false)

        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentItem = customList[position]
        holder.imageView.setImageResource(currentItem.imageRes)
        holder.textView.text = currentItem.name
    }

    override fun getItemCount() = customList.size

}
