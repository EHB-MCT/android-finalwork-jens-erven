package com.example.android.marsphotos.network

import com.squareup.moshi.Json

/**
 * This data class defines a Mars photo which includes an ID, and the image URL.
 * The property names of this data class are used by Moshi to match the names of values in JSON.
 */
data class Employee(
    // the "?" at the end allows the value to be equal to null.
    // the value at name = "the real name of the variable in the json data"
    // everything past (val) is meant to clarify how the variable is going to be named,so we can get this variable data by this new name.
    @Json(name = "id") val id: Int?,
    @Json(name ="category") val category: String?,
    @Json(name ="country") val country: String?,
    @Json(name ="first_name") val first_name: String?,
    @Json(name ="last_name") val last_name: String?,
    @Json(name ="shirt_name") val shirt_name: String?,
    @Json(name ="shirt_number") val shirt_number: String?,
    @Json(name ="birth_date") val birth_date: String?,
    @Json(name ="nationality") val nationality: String?,
    @Json(name ="start_date") val start_date: String?,
    @Json(name ="avatar") val avatar: String?,
    @Json(name ="image") val image: String?,



){
    val fullname: String
    get() = "$first_name $last_name"
}