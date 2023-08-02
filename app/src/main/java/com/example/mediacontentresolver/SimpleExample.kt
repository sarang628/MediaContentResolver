package com.example.mediacontentresolver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mediacontentresolverlibrary.MediaContentResolver

class SimpleExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
//        val activityMainBinding = ActivitySimpleExampleBinding.inflate(layoutInflater)
//        setContentView(activityMainBinding.root)

        val mediaContentResolver = MediaContentResolver.newInstance(this)
        mediaContentResolver.requestPermission(this)
//        val str = mediaContentResolver.getFolderList().toString()
//        activityMainBinding.tv.text = str

//        activityMainBinding.tv1.text = mediaContentResolver.getFolderListWithCount().toString()
    }
}