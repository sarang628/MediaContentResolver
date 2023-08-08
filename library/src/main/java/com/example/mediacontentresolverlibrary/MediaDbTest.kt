package com.example.mediacontentresolverlibrary

import android.Manifest
import android.content.Context
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mediacontentresolverlibrary.data.PictureAll

class MediaDbTest {
    fun test(applicationContext: Context) {
        val projection = arrayOf("")//arrayOf(media-database-columns-to-retrieve)
        val selection = ""//sql-where-clause-with-placeholder-variables
        val selectionArgs = arrayOf("")//values-of-placeholder-variables
        val sortOrder = ""//sql-order-by-clause

        applicationContext.contentResolver.query(
            //MediaStore.media-type.Media.EXTERNAL_CONTENT_URI,
            MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
            projection,
            selection,
            selectionArgs,
            sortOrder
        )?.use { cursor ->
            while (cursor.moveToNext()) {
                // Use an ID column from the projection to get
                // a URI representing the media item itself.
            }
        }
    }
}

@Preview
@Composable
fun PreViewMediaDbTest() {

    val launch = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = {

        })

    val context = LocalContext.current
    var expand by remember { mutableStateOf(false) }
    var list: List<PictureAll> by remember { mutableStateOf(ArrayList<PictureAll>()) }
    val TAG = "MediaDbTest";

    Box(Modifier.fillMaxSize()) {
        //상단 드롭다운
        Column {
            Button(onClick = {
                expand = true
            }) {
                Text(text = "MediaStore")
            }
            DropdownMenu(
                expanded = expand, onDismissRequest = { /*TODO*/ }) {
                DropdownMenuItem(
                    text = { Text(text = "MediaStore.Video") },
                    onClick = {
                        expand = false
                        MediaStore.Video.Media.ALBUM
                    })
                DropdownMenuItem(
                    text = { Text(text = "MediaStore.Video") },
                    onClick = { expand = false })
                DropdownMenuItem(
                    text = { Text(text = "MediaStore.Video") },
                    onClick = { expand = false })
            }

            //미디어 리스트
            Box(modifier = Modifier.height(500.dp)) {
                CursorToItem(list = list)
            }

            //하단 버튼
            Column(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    Log.d("MediaDbTest", "query!")
                    val cursor = MediaStoreManager.test(context = context)
                    cursor?.let { list = PictureAll.parse(cursor = it) }
                }) {
                    Text(text = "Query!")
                }
                Button(onClick = {
                    launch.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                }) {
                    Text(text = "Permission")
                }
            }
        }
    }

}

@Composable
fun CursorToItem(list: List<PictureAll>) {
    LazyColumn(content = {
        items(list.size) {
            Text(text = "----------------------------------------")
            Text(list.get(it).toString())
            Text(text = "----------------------------------------")
        }
    })
}