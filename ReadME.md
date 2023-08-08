# 안드로이드 미디어 문서
https://developer.android.com/training/data-storage/shared/media

더 풍부한 사용자 경험을 제공하기위해, 많은 앱들은 외장메모리에 있는 미디어에 접근 가능하게 만들고 있습니다. 안드로이드 프레임워크는 media store라는 최적화된 인덱스를 제공합니다. 사용자에게 보다 쉽게 미디어를 수정하고 업데이트 할 수 있게 만들 수 있습니다. 

```
Note: 자신의 앱에서만 값을 제공하는 미디어파일을 작업하고자 한다면 아래 링크를 참조하기바랍니다.
https://developer.android.com/training/data-storage/app-specific#media
```

## Photo picker
media store 대신 Android photo picker을 사용 할 수 있습니다. OS에 탑제되어있는 기능입니다. 권한없이 사용자가 안전하게 사진을 선택 할 수 있습니다. 지원되는 기기들이 한정되어있으니 참고바랍니다.

https://developer.android.com/training/data-storage/shared/photopicker

## Media Store
media store 는 ContentResolver 사용해 접근할 수 있습니다. 
```
val projection = arrayOf(media-database-columns-to-retrieve)
val selection = sql-where-clause-with-placeholder-variables
val selectionArgs = values-of-placeholder-variables
val sortOrder = sql-order-by-clause

applicationContext.contentResolver.query(
    MediaStore.media-type.Media.EXTERNAL_CONTENT_URI,
    projection,
    selection,
    selectionArgs,
    sortOrder
)?.use { cursor ->
    while (cursor.moveToNext()) {
        // Use an ID column from the projection to get
        // a URI representing the media item itself.
    }
}
```

위 코드 사용시 외장 메모리에 있는 사진에도 접근 할 수 있습니다:

- DCIM/ and Pictures/ 디렉토리에 있는 이미지 검색. 
- DCIM/, Movies/, and Pictures/ 디렉토리에 있는 비디오 검색.
- Alarms/, Audiobooks/, Music/, Notifications/, Podcasts/, and Ringtones/ 오디오 검색
- Download/ 다운로드 파일 (Android 10 (API level 29) 이상 에서 동작)
- Recordings/ 음성 (Android 11 (API level 30) 이하 사용 불가)
- Music/ or Movies/ 오디오 플레이리스트
- MediaStore.Images, MediaStore.Video, MediaStore.Audio. MediaStore.Downloads(Android 10 (API level 29)이상) 테이블에 정보 저장
- MediaStore.Files (Android 10 이상) scoped storage 범위에 따라 파일 표시
- scoped storage를 지원한다면 앱에서 생성한 사진, 비디오, 오디오만 표시
- scoped storage를 지원하지 않는다면 모든 파일 표시
Most developers don't need to use MediaStore.Files to view media files from other apps, but if you have a specific requirement to do so, you can declare the READ_EXTERNAL_STORAGE permission. We recommend, however, that you use the MediaStore APIs to open files that your app hasn't created.

# Request necessary permissions
미디어 파일에 접근을 위해서는 권한을 요청해야합니다. 필요로하는 파일에 해당하는 권한만 요청하도록, 권한이 어떤 파일들을 접근을 가능하게 해주는지 잘 파악해야합니다.

## 저장소 권한
앱 자체에서 생성한 미디어 파일에만 접근 할 경우 권한 요청은 필요없습니다.

### 앱이 소유한 미디어 파일에 접근
안드로이드 10 이상에서는 저장소 관련 권한 필요로 하지 않습니다.

### 다른 미디어 파일에 접근

```
<!-- 이미지/사진 only -->
<uses-permission android:name="android.permission.READ_MEDIA_IMAGES" />

<!-- 비디오만 only -->
<uses-permission android:name="android.permission.READ_MEDIA_VIDEO" />

<!-- 오디오만 only -->
<uses-permission android:name="android.permission.READ_MEDIA_AUDIO" />

<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>

<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"
                 android:maxSdkVersion="29" />
```

# Check for updates to the media store
soon..

# Query a media collection


## 안드로이드 프레임워크 미디어
https://developer.android.com/reference/android/provider/MediaStore

![sample](./sample/sample.png)

```
interface MediaContentResolver {

    fun requestPermission(activity: Activity)

    fun getFolderList(): ArrayList<String>

    fun getFolderListImageData(): ArrayList<ImageData>

    fun getFolderListWithCount(): Map<String, Int>

    fun getPictureList(): ArrayList<String>

    fun getPictureList(folderPath: String): ArrayList<String>

    fun getPictureListImageData(folderPath: String): ArrayList<ImageData>

    fun getPictureListCursor(folderPath: String): Cursor?

    fun getFolderListCursor(): Cursor?

    fun printAvailableMediaColunm()
    fun printAvailableMediaColunmWithContents()

    companion object {
        fun newInstance(context: Context): MediaContentResolver {
            return MediaContentResolverImpl(context)
        }
    }
}
```

