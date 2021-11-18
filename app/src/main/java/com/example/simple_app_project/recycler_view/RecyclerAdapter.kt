package com.example.simple_app_project.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simple_app_project.R

class RecyclerAdapter : RecyclerView.Adapter<BookItemViewHolder>() {
    private val images: ArrayList<Int> = ArrayList()
    private val titleText: ArrayList<String> = ArrayList()
    private val contextText: ArrayList<String> = ArrayList()

    var callback: Callback? = null
    private val clickListener = View.OnClickListener { v -> v?.let { callback?.onItemClicked(it) } }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        itemView.setOnClickListener(clickListener)

        return BookItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookItemViewHolder, position: Int) {
        holder.itemImage.setImageResource(images[position])
        holder.itemTitleText.text = titleText[position]
        holder.itemContextText.text = contextText[position]
    }

    override fun getItemCount(): Int {
        return titleText.size
    }

    interface Callback {
        fun onItemClicked(view: View)
    }
}
