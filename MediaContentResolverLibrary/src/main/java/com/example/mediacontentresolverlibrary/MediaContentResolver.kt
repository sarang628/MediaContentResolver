package com.example.mediacontentresolverlibrary

import android.app.Activity
import android.content.Context
import android.database.Cursor
import android.provider.MediaStore

interface MediaContentResolver {

    fun requestPermission(activity: Activity)

    fun getFolderList(): ArrayList<String>

    fun getFolderListImageData(): ArrayList<ImageData>

    fun getFolderListWithCount() : Map<String, Int>

    fun getPictureList(): ArrayList<String>

    fun getPictureList(folderPath : String): ArrayList<String>

    fun getPictureListImageData(folderPath : String): ArrayList<ImageData>

    fun getPictureListCursor(folderPath : String): Cursor?

    fun getFolderListCursor(): Cursor?

    companion object {
        fun newInstance(context: Context): MediaContentResolver {
            return MediaContentResolverImpl(context)
        }
    }
}