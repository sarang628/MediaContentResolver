package com.example.mediacontentresolver.media_colunm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mediacontentresolver.databinding.ActivityMediaColunmBinding
import com.example.mediacontentresolverlibrary.MediaContentResolver

class MediaColunmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMediaColunmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mediaContentResolver = MediaContentResolver.newInstance(this)
        mediaContentResolver.requestPermission(this)

        binding.rv.adapter = ImgAdapter().apply {
            setPicturePaths(mediaContentResolver.getDetailPictureList())
        }
    }
}