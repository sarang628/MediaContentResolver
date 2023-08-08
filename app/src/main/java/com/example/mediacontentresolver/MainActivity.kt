package com.example.mediacontentresolver

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mediacontentresolver.media_colunm.MediaColunmActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Button(onClick = {
                    startActivity(Intent(this@MainActivity, MediaColunmActivity::class.java))
                }) {
                    Text(text = "컬럼보기")
                }

                Button(onClick = {
                    try {

                    } catch (e: Exception) {
                        Log.d("MainActivity", e.toString())
                    }
                }) {

                }
            }
        }
    }
}


@Preview
@Composable
fun test() {
    Text(text = "test")
}
