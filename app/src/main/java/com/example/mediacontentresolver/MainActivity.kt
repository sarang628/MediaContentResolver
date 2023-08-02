package com.example.mediacontentresolver

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import com.example.mediacontentresolver.media_colunm.MediaColunmActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Text(text = "test")
                Button(onClick = {

                    startActivity(Intent(this@MainActivity, SimpleExample::class.java))
                }) {
                    Text(text = "권한요청")
                }

                Button(onClick = {
                    startActivity(Intent(this@MainActivity, MediaColunmActivity::class.java))
                }) {
                    Text(text = "컬럼보기")
                }
            }
        }
    }
}

