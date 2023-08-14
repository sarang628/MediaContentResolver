package com.example.mediacontentresolverlibrary.example

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.mediacontentresolverlibrary.media_content_util.printAvailableMediaColunmWithContents

@Preview
@Composable
fun PrintAvailableMediaColunmWithContents() {
    printAvailableMediaColunmWithContents(LocalContext.current)
}