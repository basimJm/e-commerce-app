package com.task.ecommerce.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
    @Json(name = "sort")
    val sort: Int?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "type")
    val type: Int?,
    @Json(name = "data")
    val `data`: List<Data>?
)