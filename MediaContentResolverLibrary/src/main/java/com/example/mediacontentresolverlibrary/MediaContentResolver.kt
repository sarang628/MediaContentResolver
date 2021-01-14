package com.example.mediacontentresolverlibrary

import android.app.Activity
import android.content.Context

interface MediaContentResolver {

    fun requestPermission(activity: Activity)

    fun getFolderList(): ArrayList<String>

    companion object {
        fun newInstance(context: Context): MediaContentResolver {
            return MediaContentResolverImpl(context)
        }
    }
}