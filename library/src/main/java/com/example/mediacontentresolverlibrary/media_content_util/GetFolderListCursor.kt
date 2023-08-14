package com.example.mediacontentresolverlibrary.media_content_util

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore

internal fun getFolderListCursor(context: Context): Cursor? {
    val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
    val projection = arrayOf(
        MediaStore.Images.Media.BUCKET_DISPLAY_NAME,
        MediaStore.Images.Media.BUCKET_ID
    )
    val cursor = context.contentResolver.query(uri, projection, null, null, null)
    return cursor
}