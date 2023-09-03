package com.example.mediacontentresolverlibrary.media_content_util

import android.content.Context
import android.provider.MediaStore

internal fun printAvailableMediaColunm(context: Context) {
    val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
    val cursor = context.contentResolver.query(uri, null, null, null, null)

    if (cursor != null) {
        while (cursor.moveToNext()) {
            try {
                val columnNames = cursor.columnNames
                cursor.close()
                return
            } catch (e: Exception) {

            }
        }
        cursor.close()
    }
}