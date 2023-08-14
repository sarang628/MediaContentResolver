package com.example.mediacontentresolverlibrary.example

import android.database.Cursor
import androidx.core.database.getIntOrNull
import androidx.core.database.getShortOrNull

class CursorUtil {
    companion object {
        fun toStringList(cursor: Cursor?): List<String> {

            if (cursor == null)
                return ArrayList()

            val list = ArrayList<String>()

            while (cursor.moveToNext()) {
                list.add("---------------------------------------------------------")
                for (columnName: String in cursor.columnNames) {

                    val index = cursor.getColumnIndex(columnName)
//                    if(cursor.getBlobOrNull(index) != null) list.add(""+cursor.getBlobOrNull(index))
//                    if(cursor.getStringOrNull(index) != null) list.add(""+cursor.getStringOrNull(index))
//                    if(cursor.getDoubleOrNull(index) != null) list.add(""+cursor.getDoubleOrNull(index))
//                    if(cursor.getFloatOrNull(index) != null) list.add(""+cursor.getFloatOrNull(index))
                    if (cursor.getType(index) == Cursor.FIELD_TYPE_INTEGER
                        && cursor.getIntOrNull(index) != null
                    ) {
                        list.add("$columnName = ${cursor.getIntOrNull(index)}")
                    }
//                    if(cursor.getLongOrNull(index) != null) list.add(""+cursor.getLongOrNull(index))
//                    if(cursor.getShortOrNull(index) != null) list.add(""+cursor.getShortOrNull(index))
                }
                list.add("---------------------------------------------------------")
            }

            return list;
        }
    }
}