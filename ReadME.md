# 안드로이드 미디어 라이브러리

안드로이드 미디어 문서 분석 및 라이브러리 제공을 목적으로 만들었습니다.

# 미디어 문서 분석

## [공식 사이트 문서](./documents/Media.md)

# 미디어 실습

## 미디어 DB 조회하기

# 미디어 라이브러리 만들기

## 라이브러리 인터페이스 만들기

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

### 샘플

![sample](./sample/sample.png)

