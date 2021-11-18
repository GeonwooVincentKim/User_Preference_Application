package com.example.simple_app_project.recycler_view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.simple_app_project.R

class BookItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val itemLayoutCardView: CardView = itemView.findViewById(R.id.itemLayoutCardView)
    val itemLayoutInnerCardView: ConstraintLayout = itemView.findViewById(R.id.itemLayoutInnerCardView)

    val itemImage: ImageView = itemView.findViewById(R.id.itemImage)
    val itemTitleText: TextView = itemView.findViewById(R.id.itemTitleText)
    val itemContextText: TextView = itemView.findViewById(R.id.itemContextText)
}