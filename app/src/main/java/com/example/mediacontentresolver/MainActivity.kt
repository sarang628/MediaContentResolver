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
import com.example.mediacontentresolver.media_colunm.MediaColunmActivity
import com.example.mediacontentresolverlibrary.MediaContentResolver

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.btnSimple.setOnClickListener {
            startActivity(Intent(this, SimpleExample::class.java))
        }

        activityMainBinding.btnMediaColunm.setOnClickListener {
            startActivity(Intent(this, MediaColunmActivity::class.java))
        }
    }
}

