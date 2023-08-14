package com.example.mediacontentresolverlibrary.media_content_util

import android.app.Activity
import android.content.Context
import android.database.Cursor
import com.example.mediacontentresolverlibrary.ImageData
import com.example.mediacontentresolverlibrary.data.PictureDetail
import com.example.mediacontentresolverlibrary.saf.SAFMediaContentResolverImpl

/**
 *
 */
interface MediaContentResolver {

    fun requestPermission(activity: Activity)

    fun getFolderList(): ArrayList<String>

    fun getFolderListImageData(): ArrayList<ImageData>

    fun getFolderListWithCount(): Map<String, Int>

    fun getPictureList(): ArrayList<String>

    fun getPictureList(folderPath: String): ArrayList<String>

    fun getDetailPictureList(): ArrayList<PictureDetail>

    fun getPictureListImageData(folderPath: String): ArrayList<ImageData>

    fun getPictureListCursor(folderPath: String): Cursor?

    fun getFolderListCursor(): Cursor?

    /**
     * 사용 가능한 컬럼 보기
     */
    fun printAvailableMediaColunm()

    /**
     * 사용 가능한 미디어 컬럼과 내용 출력
     */
    fun printAvailableMediaColunmWithContents()

    companion object {
        fun newInstance(context: Context): MediaContentResolver {
            return MediaContentResolverImpl(context)
        }

        fun newInstance1(context: Context): MediaContentResolver {
            return SAFMediaContentResolverImpl(context)
        }
    }
}