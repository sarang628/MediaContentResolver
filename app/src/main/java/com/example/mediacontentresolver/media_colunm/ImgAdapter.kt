package com.example.mediacontentresolver.media_colunm

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mediacontentresolver.R
import com.example.mediacontentresolverlibrary.data.PictureDetail

class ImgAdapter : RecyclerView.Adapter<ImageViewHolder>() {
    var picturePath = ArrayList<PictureDetail>()

    fun setPicturePaths(list: ArrayList<PictureDetail>) {
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
            .load(picturePath[position].path)
            .centerCrop()
            .into(holder.itemView.findViewById(R.id.iv));

        holder.itemView.findViewById<TextView>(R.id.tv_info).text = picturePath[position].info
    }
}