package com.example.mediacontentresolverlibrary.media_content_util

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore

internal fun getPictureListCursor(context: Context, folderPath: String): Cursor? {
    val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
    val projection = arrayOf(
        MediaStore.Images.Media.DATA,
        MediaStore.Images.Media.BUCKET_DISPLAY_NAME,
        MediaStore.Images.Media.DATE_TAKEN
    )
    val selection = "${MediaStore.Video.Media.BUCKET_DISPLAY_NAME} = ?"
    val selectionArgs = arrayOf(folderPath)
    val sortOrder = "${MediaStore.Video.Media.DATE_TAKEN} DESC"
    return context.contentResolver.query(uri, projection, selection, selectionArgs, sortOrder)
}