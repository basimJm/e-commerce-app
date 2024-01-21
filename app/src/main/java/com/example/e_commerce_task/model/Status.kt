package com.task.ecommerce.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Status(
    @Json(name = "code")
    val code: Int?,
    @Json(name = "massage")
    val massage: String?
)