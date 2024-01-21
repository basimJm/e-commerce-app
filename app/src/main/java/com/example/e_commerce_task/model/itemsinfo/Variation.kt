package com.task.ecommerce.model.itemsinfo

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Variation(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "image")
    val image: List<Image>?,
    @Json(name = "price")
    val price: String?,
    @Json(name = "title")
    val title: String?
)