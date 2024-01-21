package com.task.ecommerce.model.checkout

import com.task.ecommerce.model.Status
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreateOrderRemoteModel(
    @Json(name = "status") val status: Status,
    @Json(name = "results") val results: CreateOrderResult
)