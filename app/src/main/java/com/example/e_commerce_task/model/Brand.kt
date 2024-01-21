package com.task.ecommerce.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Brand(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "title")
    val title: String?
)