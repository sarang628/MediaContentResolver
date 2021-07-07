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

