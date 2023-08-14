package com.example.mediacontentresolverlibrary.example

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun SampleMediaStore() {
    Column(Modifier.padding(start = 5.dp)) {
        Row {
            Text(text = "val", color = Color.Blue)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "projection")
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "=")
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "arrayOf(media-database-columns-to-retrieve)")

        }
        Row {
            Text(text = "val", color = Color.Blue)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "selection")
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "= sql-where-clause-with-placeholder-variables", color = Color.Magenta)
        }
        Row {
            Text(text = "val", color = Color.Blue)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "selectionArgs")
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "= values-of-placeholder-variables", color = Color.Magenta)
        }
        Row {
            Text(text = "val", color = Color.Blue)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "sortOrder")
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "= sql-order-by-clause", color = Color.Magenta)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "applicationContext.contentResolver.query(")
        Text(text = "MediaStore.media-type.Media.EXTERNAL_CONTENT_URI,")
        Text(text = "projection,")
        Text(text = "selection,")
        Text(text = "selectionArgs,")
        Text(text = "sortOrder")
        Text(text = ")?.use { cursor ->")
        Text(text = "while (cursor.moveToNext()) {")
        Text(text = "// Use an ID column from the projection to get")
        Text(text = "// a URI representing the media item itself.")
        Text(text = "}")
        Text(text = "}")

    }
}