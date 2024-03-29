package com.example.mediacontentresolver

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mediacontentresolver.databinding.ActivitySimpleExampleBinding
import com.example.mediacontentresolverlibrary.MediaContentResolver

class SimpleExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = ActivitySimpleExampleBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val mediaContentResolver = MediaContentResolver.newInstance(this)
        mediaContentResolver.requestPermission(this)
        val str = mediaContentResolver.getFolderList().toString()
        activityMainBinding.tv.text = str

        activityMainBinding.tv1.text = mediaContentResolver.getFolderListWithCount().toString()
    }
}