# 안드로이드 미디어 문서
https://developer.android.com/reference/android/provider/MediaStore

더 풍부한 사용자 경험을 제공하기위해, 많은 앱들은 외장메모리에 있는 미디어에 접근 가능하게 만들고 있습니다. 안드로이드 프레임워크는 media store라는 최적화된 인덱스를 제공합니다. 사용자에게 보다 쉽게 미디어를 수정하고 업데이트 할 수 있게 만들 수 있습니다. 

```
Note: 자신의 앱에서만 값을 제공하는 미디어파일을 작업하고자 한다면 아래 링크를 참조하기바랍니다.
https://developer.android.com/training/data-storage/app-specific#media
```

## Photo picker
미디어 스토어를 대신 안드로이드에 탑제되어있는 Android photo picker을 사용 할 수 있습니다. 권한없이 사용자가 안전하게 사진을 선택 할 수 있습니다. 지원되는 기기들이 한정되어있으니 참고바랍니다.

https://developer.android.com/training/data-storage/shared/media



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

