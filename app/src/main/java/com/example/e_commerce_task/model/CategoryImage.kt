package com.task.ecommerce.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CategoryImage(
    @Json(name = "description")
    val description: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "title")
    val title: String?
)