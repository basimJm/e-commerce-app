package com.task.ecommerce.model.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item(
    @Json(name = "items_id") val itemsId: String,
    @Json(name = "quantity") val quantity: String,
    @Json(name = "items_variations_id") val itemsVariationsId: String
)