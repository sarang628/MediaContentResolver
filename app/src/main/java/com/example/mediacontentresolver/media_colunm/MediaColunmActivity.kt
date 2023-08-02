package com.example.mediacontentresolver.media_colunm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.example.mediacontentresolverlibrary.MediaContentResolver

class MediaColunmActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text(text = "test")

        }
//        val mediaContentResolver = MediaContentResolver.newInstance(this)
//        mediaContentResolver.requestPermission(this)
//        mediaContentResolver.getDetailPictureList()
    }
}