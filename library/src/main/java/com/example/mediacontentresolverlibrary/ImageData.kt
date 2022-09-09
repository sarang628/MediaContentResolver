package com.example.mediacontentresolverlibrary

import android.database.Cursor
import android.provider.MediaStore

class ImageData {

    var bucketId: Int = 0
    var data = ""
    var bucketDisplayName = ""

    fun setCursor(cursor: Cursor) {
        val index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.BUCKET_ID)
        bucketId = cursor.getInt(index)
        data = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA))
    }

    companion object {
        fun create(cursor: Cursor): ImageData {
            val imageData = ImageData()
            if (!cursor.isNull(cursor.getColumnIndex(MediaStore.Images.ImageColumns.BUCKET_ID))) {
                imageData.bucketId = cursor.getInt(cursor.getColumnIndex(MediaStore.Images.ImageColumns.BUCKET_ID))
            }

            if (!cursor.isNull(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA))) {
                imageData.data = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA))
            }

            if (!cursor.isNull(cursor.getColumnIndex(MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME))) {
                imageData.bucketDisplayName = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME))
            }


            return imageData
        }
    }
}