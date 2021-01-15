package com.example.mediacontentresolverlibrary

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

internal class MediaContentResolverImpl(val context: Context) : MediaContentResolver {

    @RequiresApi(api = Build.VERSION_CODES.M)
    override fun requestPermission(activity: Activity) {
        //권한 체크 하기
        val isPermission =
            ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
        if (isPermission == PackageManager.PERMISSION_DENIED) {
            val b = AlertDialog.Builder(activity)
            b.setMessage("이미지를 등록하기위해선 저장소 읽기 권한이 필요합니다. 허용하시겠습니까?")
            b.setPositiveButton("yes") { dialogInterface: DialogInterface?, i: Int ->
                activity.requestPermissions(
                    arrayOf(
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    ), 0x01
                )
            }
            b.setNegativeButton("no") { dialogInterface: DialogInterface?, i: Int -> activity.finish() }
            b.show()
        }
    }

    override fun getFolderList(): ArrayList<String> {
        return requestPicFolderList(context)
    }

    override fun getFolderListWithCount(): Map<String, Int> {
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Images.Media.BUCKET_DISPLAY_NAME
        )
        val cursor = context.contentResolver.query(uri, projection, null, null, null)
        val folderMap: MutableMap<String, Int> = TreeMap<String, Int>()
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val columnIndex = cursor.getColumnIndex(MediaStore.Images.Media.BUCKET_DISPLAY_NAME)
                val folder = cursor.getString(columnIndex)
                try {
                    if(folderMap[folder] == null) folderMap[folder] = 0

                    folderMap[folder] = folderMap.get(folder)!!.plus(1)
                } catch (e: Exception) {

                }
            }
            cursor.close()
        }
        return folderMap
    }

    fun requestPicFolderList(context: Context): ArrayList<String> {
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Images.Media.BUCKET_DISPLAY_NAME
        )
        val cursor = context.contentResolver.query(uri, projection, null, null, null)
        val folderMap: MutableMap<String, String> = TreeMap<String, String>()
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val columnIndex = cursor.getColumnIndex(MediaStore.Images.Media.BUCKET_DISPLAY_NAME)
                val folder = cursor.getString(columnIndex)
                try {
                    if (folderMap[folder] == null) folderMap[folder] = folder
                } catch (e: Exception) {

                }
            }
            cursor.close()
        }
        val folderList = java.util.ArrayList<String>(folderMap.values)
        return folderList
    }
}