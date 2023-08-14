package com.example.mediacontentresolverlibrary.example

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore

class MediaStoreManager {
    companion object {
        fun test(context: Context): Cursor? {
            val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            val sortOrder = "${MediaStore.Video.Media.DATE_TAKEN} DESC"
            val cursor = context.contentResolver.query(uri, null, null, null, sortOrder)
            return cursor
        }
    }
}