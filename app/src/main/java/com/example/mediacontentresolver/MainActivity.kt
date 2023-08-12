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
import com.example.mediacontentresolverlibrary.MediaColunmActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                MediaStoreTest()
                Button(onClick = {
                    startActivity(Intent(this@MainActivity, MediaColunmActivity::class.java))
                }) {
                    Text(text = "컬럼보기")
                }
            }
        }
    }
}

@Composable
fun MediaStoreTest() {
    Column {
        Text(text = "MediaStore")
    }
}


@Preview
@Composable
fun test() {
    Text(text = "test")
}
