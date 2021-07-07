package com.example.mediacontentresolver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mediacontentresolver.databinding.ActivityMainBinding
import com.example.mediacontentresolverlibrary.MediaContentResolver

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.btnSimple.setOnClickListener {
            startActivity(Intent(this, SimpleExample::class.java))
        }

        val mediaContentResolver = MediaContentResolver.newInstance(this)
        mediaContentResolver.requestPermission(this)

        activityMainBinding.rv.adapter = ImgAdapter().apply {
            setPicturePaths(mediaContentResolver.getPictureList())
        }
    }
}

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

class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}