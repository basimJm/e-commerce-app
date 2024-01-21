package com.task.ecommerce.model.itemsinfo

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Image(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "image")
    val image: String?
)