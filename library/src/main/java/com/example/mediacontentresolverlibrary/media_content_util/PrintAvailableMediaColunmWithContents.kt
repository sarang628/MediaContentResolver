package com.example.mediacontentresolverlibrary.media_content_util

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import android.util.Log

internal fun printAvailableMediaColunmWithContents(context: Context) {
    val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
    val cursor = context.contentResolver.query(uri, null, null, null, null)

    if (cursor != null) {
        while (cursor.moveToNext()) {
            try {
                val columnNames = cursor.columnNames
                for (colunmName in columnNames) {
                    val index = cursor.getColumnIndex(colunmName)
                    if (cursor.getType(index) == Cursor.FIELD_TYPE_INTEGER) {
                        Log.d("__sryang", colunmName + ":" + cursor.getInt(index).toString())
                    } else if (cursor.getType(index) == Cursor.FIELD_TYPE_FLOAT) {
                        Log.d("__sryang", colunmName + ":" + cursor.getFloat(index).toString())
                    } else if (cursor.getType(index) == Cursor.FIELD_TYPE_STRING) {
                        Log.d("__sryang", colunmName + ":" + cursor.getString(index).toString())
                    }
                }
                cursor.close()
                return
            } catch (e: Exception) {

            }
        }
        cursor.close()
    }
}