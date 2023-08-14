package com.example.mediacontentresolverlibrary.example

import android.Manifest
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sryang.library.compose.ComposeRequestPermission

@Preview
@Composable
fun PermissionTest() {
    ComposeRequestPermission(permission = Manifest.permission.CAMERA)
}