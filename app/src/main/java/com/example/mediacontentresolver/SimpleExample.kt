package com.example.mediacontentresolver

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import com.example.mediacontentresolverlibrary.MediaContentResolver

class SimpleExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Button(onClick = {
                val mediaContentResolver = MediaContentResolver.newInstance(this)
                mediaContentResolver.requestPermission(this)
                Log.d("SimpleExample", mediaContentResolver.getFolderList().toString())
                Log.d("SimpleExample", mediaContentResolver.getFolderListWithCount().toString())

            }) {
                Text(text = "test")
            }
        }
    }
}