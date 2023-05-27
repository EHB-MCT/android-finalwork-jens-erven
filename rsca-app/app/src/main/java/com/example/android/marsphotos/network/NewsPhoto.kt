package com.example.android.marsphotos.network
import java.text.SimpleDateFormat
import com.squareup.moshi.Json
import kotlin.math.abs
import java.util.*

/**
 * This data class defines a Mars photo which includes an ID, and the image URL.
 * The property names of this data class are used by Moshi to match the names of values in JSON.
 */
data class NewsPhoto(
    @Json(name = "id") val id: Int?,
    //@Json(name = "img_src") val imgSrcUrl: String,
    @Json(name = "title") val title: String?,
    @Json(name = "publication_date") val publication_date: String?,
    @Json(name = "preview_image") val preview_image: String?,
    @Json(name = "type") val type: String?,
    @Json(name = "body") val body: List<BodyItem>?,
    @Json(name= "youtube_id") val youtube_id: String?,
) {

    // reshape the publication_date to see published time based on current time
    val daysAgo: String?
        get() {
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale("nl", "BE"))
            sdf.timeZone = TimeZone.getTimeZone("Europe/Brussels")
            val date = sdf.parse(publication_date ?: return null)
            val diff = abs(Date().time - date.time)
            return when {
                diff < (60 * 60 * 1000) -> "${diff / (60 * 1000)} minuten geleden"
                diff < (24 * 60 * 60 * 1000) -> "${diff / (60 * 60 * 1000)} uren geleden"
                else -> "${diff / (24 * 60 * 60 * 1000)} dagen geleden"
            }
        }


    // All the needed code to get the "intro", "text", "image" of each article that is in the array with name "body"
    val article_intro: String?
        get() = getBodyData("intro")
    val article_text: String?
        get() = getBodyData("text")?.replace(Regex("<[^>]*>|&nbsp;|&quot;|&rdquo;|&lsquo;"), "")

    val article_image: String?
        get() = getBodyData("image")

    fun getBodyData(key: String): String? {
        return body?.firstOrNull { it.key == key }?.value
    }
    data class BodyItem(
        @Json(name = "key") val key: String?,
        @Json(name = "value") val value: String?
    )
}
