package com.task.ecommerce.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HomeRemoteModel(
    @Json(name = "status")
    val status: Status?,
    @Json(name = "results")
    val results: List<Result>?

)