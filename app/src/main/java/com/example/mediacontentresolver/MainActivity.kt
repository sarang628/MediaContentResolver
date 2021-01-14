package com.example.mediacontentresolver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mediacontentresolver.databinding.ActivityMainBinding
import com.example.mediacontentresolverlibrary.MediaContentResolver

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val mediaContentResolver = MediaContentResolver.newInstance(this)
        mediaContentResolver.requestPermission(this)
        val str = mediaContentResolver.getFolderList().toString()
        activityMainBinding.tv.text = str
    }
}