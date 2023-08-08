package com.example.mediacontentresolverlibrary.data

import android.database.Cursor
import android.provider.MediaStore
import android.util.Log

data class PictureAll(val raw: String) {
    companion object {
        fun parse(cursor: Cursor): List<PictureAll> {
            val test = ArrayList<PictureAll>()
            while (cursor.moveToNext()) {
                try {
                    val columnNames = cursor.columnNames
                    val data =
                        cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                    var info = StringBuffer()
                    for (colunmName in columnNames) {
                        val index = cursor.getColumnIndex(colunmName)
                        if (cursor.getType(index) == Cursor.FIELD_TYPE_INTEGER) {
                            info.append(
                                colunmName + ":" + cursor.getInt(index).toString()
                            )
                        } else if (cursor.getType(index) == Cursor.FIELD_TYPE_FLOAT) {
                            info.append(
                                colunmName + ":" + cursor.getFloat(index).toString()
                            )
                        } else if (cursor.getType(index) == Cursor.FIELD_TYPE_STRING) {
                            info.append(
                                colunmName + ":" + cursor.getString(index).toString()
                            )
                        } else if (cursor.getType(index) == Cursor.FIELD_TYPE_NULL) {
                            info.append("$colunmName:Cursor.FIELD_TYPE_NULL")
                        }
                        info.append(System.getProperty("line.separator"))
                    }
                    test.add(PictureAll(info.toString()))
                    Log.d("MediaDbTest", data)
                } catch (e: Exception) {

                }
            }
            cursor.close()
            return test
        }
    }
}
