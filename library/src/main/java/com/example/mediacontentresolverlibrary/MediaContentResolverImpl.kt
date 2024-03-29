package com.example.mediacontentresolverlibrary

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.database.Cursor
import android.media.Image
import android.os.Build
import android.provider.MediaStore
import android.text.TextUtils
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.mediacontentresolverlibrary.data.PictureDetail
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

internal class MediaContentResolverImpl(private val context: Context) : MediaContentResolver {

    @RequiresApi(api = Build.VERSION_CODES.M)
    override fun requestPermission(activity: Activity) {
        //권한 체크 하기
        val isPermission =
            ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
        if (isPermission == PackageManager.PERMISSION_DENIED) {
            val b = AlertDialog.Builder(activity)
            b.setMessage("이미지를 등록하기위해선 저장소 읽기 권한이 필요합니다. 허용하시겠습니까?")
            b.setPositiveButton("yes") { _: DialogInterface?, _: Int ->
                activity.requestPermissions(
                    arrayOf(
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    ), 0x01
                )
            }
            b.setNegativeButton("no") { _: DialogInterface?, _: Int -> activity.finish() }
            b.show()
        }
    }

    override fun getFolderList(): ArrayList<String> {
        val cursor = getFolderListCursor()
        val folderMap: MutableMap<String, String> = TreeMap()
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

    override fun getFolderListImageData(): ArrayList<ImageData> {
        val cursor = getFolderListCursor()
        val folders = ArrayList<ImageData>()
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    folders.add(ImageData.create(cursor))
                } catch (e: Exception) {

                }
            }
            cursor.close()
        }
        return folders
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
                    if (folderMap[folder] == null) folderMap[folder] = 0

                    folderMap[folder] = folderMap.get(folder)!!.plus(1)
                } catch (e: Exception) {

                }
            }
            cursor.close()
        }
        return folderMap
    }

    override fun getPictureList(): ArrayList<String> {
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Images.Media.DATA,
            MediaStore.Images.Media.DATE_TAKEN
        )

        val sortOrder = "${MediaStore.Video.Media.DATE_TAKEN} DESC"
        val cursor = context.contentResolver.query(uri, projection, null, null, sortOrder)
        val folderMap = ArrayList<String>()
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val columnIndex = cursor.getColumnIndex(MediaStore.Images.Media.DATA)
                try {
                    val folder = cursor.getString(columnIndex)
                    folderMap.add(folder)
                } catch (e: Exception) {

                }
            }
            cursor.close()
        }
        return folderMap
    }

    override fun getPictureList(folderPath: String): ArrayList<String> {
        val cursor = getPictureListCursor(folderPath)
        val folderMap = ArrayList<String>()
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val columnIndex = cursor.getColumnIndex(MediaStore.Images.Media.DATA)
                try {
                    val folder = cursor.getString(columnIndex)
                    folderMap.add(folder)
                } catch (e: Exception) {

                }
            }
            cursor.close()
        }
        return folderMap
    }

    override fun getDetailPictureList(): ArrayList<PictureDetail> {
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val sortOrder = "${MediaStore.Video.Media.DATE_TAKEN} DESC"
        val cursor = context.contentResolver.query(uri, null, null, null, sortOrder)
        val list = ArrayList<PictureDetail>()
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    val columnNames = cursor.columnNames
                    val data =
                        cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                    var info = StringBuffer()
                    for (colunmName in columnNames) {
                        val index = cursor.getColumnIndex(colunmName)
                        if (cursor.getType(index) == Cursor.FIELD_TYPE_INTEGER) {
                            info.append(colunmName + ":" + cursor.getInt(index).toString())
                        } else if (cursor.getType(index) == Cursor.FIELD_TYPE_FLOAT) {
                            info.append(colunmName + ":" + cursor.getFloat(index).toString())
                        } else if (cursor.getType(index) == Cursor.FIELD_TYPE_STRING) {
                            info.append(colunmName + ":" + cursor.getString(index).toString())
                        } else if (cursor.getType(index) == Cursor.FIELD_TYPE_NULL) {
                            info.append("$colunmName:Cursor.FIELD_TYPE_NULL")
                        }
                        info.append(System.getProperty("line.separator"))
                    }
                    list.add(PictureDetail(data, info.toString()))

                } catch (e: Exception) {

                }
            }
            cursor.close()
        }
        return list
    }

    override fun getPictureListImageData(folderPath: String): ArrayList<ImageData> {
        val cursor = getPictureListCursor(folderPath)
        val imageDatas = ArrayList<ImageData>()

        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    imageDatas.add(ImageData.create(cursor))
                } catch (e: Exception) {

                }
            }
            cursor.close()
        }
        return imageDatas
    }

    override fun getPictureListCursor(folderPath: String): Cursor? {
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

    override fun getFolderListCursor(): Cursor? {
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Images.Media.BUCKET_DISPLAY_NAME,
            MediaStore.Images.Media.BUCKET_ID
        )
        val cursor = context.contentResolver.query(uri, projection, null, null, null)
        return cursor
    }

    override fun printAvailableMediaColunm() {
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val cursor = context.contentResolver.query(uri, null, null, null, null)

        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    val columnNames = cursor.columnNames
                    cursor.close()
                    Log.d("__sryang", Arrays.toString(columnNames))
                    return
                } catch (e: Exception) {

                }
            }
            cursor.close()
        }
    }

    override fun printAvailableMediaColunmWithContents() {
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
}