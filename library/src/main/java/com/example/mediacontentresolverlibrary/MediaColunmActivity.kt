package com.example.mediacontentresolverlibrary

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import com.example.mediacontentresolverlibrary.media_content_util.MediaContentResolver

class MediaColunmActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text(text = "test")
            Button(onClick = {
                val mediaContentResolver = MediaContentResolver.newInstance(this)
                mediaContentResolver.requestPermission(this)
                Log.d("MediaColunmActivity",
                    mediaContentResolver.getDetailPictureList().toString())
            }) {

            }
        }
    }
}