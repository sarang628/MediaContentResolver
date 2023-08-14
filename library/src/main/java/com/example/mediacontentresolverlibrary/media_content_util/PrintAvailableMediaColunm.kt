package com.example.mediacontentresolverlibrary.media_content_util

import android.content.Context
import android.provider.MediaStore
import android.util.Log
import java.util.Arrays

internal fun printAvailableMediaColunm(context: Context) {
    val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
    val cursor = context.contentResolver.query(uri, null, null, null, null)

    if (cursor != null) {
        while (cursor.moveToNext()) {
            try {
                val columnNames = cursor.columnNames
                cursor.close()
                Log.d("__sryang", Arrays.toString(columnNames))
                return
            } catch (e: Exception) {

            }
        }
        cursor.close()
    }
}