package com.example.android.marsphotos.network

import com.squareup.moshi.Json
import java.text.SimpleDateFormat
import java.util.*
import java.util.Date
import kotlin.math.abs

data class MatchPhoto (
    @Json(name = "id") val id: Int?,
    //@Json(name = "img_src") val imgSrcUrl: String,
    @Json(name = "status") val status: String?,
    @Json(name = "outmatch") val outmatch: Boolean?,
    @Json(name = "schedule") val schedule: Schedule?,
    @Json(name = "score") val score: Score?,
    @Json(name = "opponent") val opponent: Opponent?,
    @Json(name ="league") val league: League?
) {


    val scheduled_date:String?
    get(){
        return schedule?.startTimestamp?.let { startTimestamp ->
            val inputDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.getDefault())
            val outputDateFormat = SimpleDateFormat("dd MMM HH:mm", Locale.getDefault())
            val date = inputDateFormat.parse(startTimestamp)
            outputDateFormat.format(date)
        }
    }

    val status_style_cardborder: String?
    get(){
        if (status == "FINISHED"){
            return "#F5F5F5"
        }
        return "#F2B751"

    }









    val league_name: String?
    get(){
        return league?.name
    }

    val opponent_logo: String?
    get(){
        return opponent?.opponent_logo
    }

    val rsca_score: String?
    get(){
        return score?.rsca_score.toString()
    }

    val opponent_score: String?
    get(){
        return score?.opponent_score.toString()
    }

    val score_results: String?
    get(){
        if (rsca_score != "null" && opponent_score != "null"){
            return "${rsca_score}  |  ${opponent_score}"
        }
        return ""
    }

    data class Schedule (
        @Json(name = "date") val date: String?,
        @Json(name = "date_pending") val datePending: Boolean?,
        @Json(name = "date_range") val dateRange: List<Any>?,
        @Json(name = "start_time") val startTime: String?,
        @Json(name = "start_timestamp") val startTimestamp: String?
    )

    data class Score (
        @Json(name = "rsca") val rsca_score: Int?,
        @Json(name = "opponent") val opponent_score: Int?
    )

    data class Opponent (
        @Json(name = "name") val opponent_name: String?,
        @Json(name = "short_name") val opponent_shortName: String?,
        @Json(name = "logo") val opponent_logo: String?
    )

    data class League(
        @Json(name = "name") val name: String?,
    )


}
