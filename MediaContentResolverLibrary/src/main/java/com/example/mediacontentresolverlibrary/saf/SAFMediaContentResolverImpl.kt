package com.example.mediacontentresolverlibrary.saf

import android.app.Activity
import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import android.util.Log
import com.example.mediacontentresolverlibrary.ImageData
import com.example.mediacontentresolverlibrary.MediaContentResolver
import com.example.mediacontentresolverlibrary.data.PictureDetail
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class SAFMediaContentResolverImpl(val context: Context) : MediaContentResolver {
    override fun requestPermission(activity: Activity) {

    }

    override fun getFolderList(): ArrayList<String> {
        TODO("Not yet implemented")
    }

    override fun getFolderListImageData(): ArrayList<ImageData> {
        TODO("Not yet implemented")
    }

    override fun getFolderListWithCount(): Map<String, Int> {
        TODO("Not yet implemented")
    }

    override fun getPictureList(): ArrayList<String> {
        return ArrayList()
    }

    override fun getPictureList(folderPath: String): ArrayList<String> {
        TODO("Not yet implemented")
    }

    override fun getDetailPictureList(): ArrayList<PictureDetail> {
        TODO("Not yet implemented")
    }

    override fun getPictureListImageData(folderPath: String): ArrayList<ImageData> {
        TODO("Not yet implemented")
    }

    override fun getPictureListCursor(folderPath: String): Cursor? {
        TODO("Not yet implemented")
    }

    override fun getFolderListCursor(): Cursor? {
        TODO("Not yet implemented")
    }

    override fun printAvailableMediaColunm() {
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val cursor = context.contentResolver.query(uri, null, null, null, null)

        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    val columnNames = cursor.columnNames
                    cursor.close()
                    Log.d("__sarang", Arrays.toString(columnNames))
                    return
                } catch (e: Exception) {

                }
            }
            cursor.close()
        }
    }

    override fun printAvailableMediaColunmWithContents() {

    }
}