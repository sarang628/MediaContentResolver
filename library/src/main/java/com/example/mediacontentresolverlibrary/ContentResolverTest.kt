package com.example.mediacontentresolverlibrary

import android.content.Context
import android.provider.MediaStore

fun test(applicationContext: Context) {
    val uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI
    val projection = arrayOf("")//arrayOf(media-database-columns-to-retrieve)
    val selection = ""//sql-where-clause-with-placeholder-variables
    val selectionArgs = arrayOf("")//values-of-placeholder-variables
    val sortOrder = ""//sql-order-by-clause

    applicationContext.contentResolver.query(
        uri,
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