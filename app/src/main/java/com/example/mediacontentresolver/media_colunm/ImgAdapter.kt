package com.example.mediacontentresolver.media_colunm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mediacontentresolver.R

class ImgAdapter : RecyclerView.Adapter<ImageViewHolder>() {
    var picturePath = ArrayList<String>()

    fun setPicturePaths(list: ArrayList<String>) {
        picturePath = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_img, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return picturePath.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        Glide
            .with(holder.itemView.context)
            .load(picturePath[position])
            .centerCrop()
            .into(holder.itemView.findViewById(R.id.iv));
    }
}