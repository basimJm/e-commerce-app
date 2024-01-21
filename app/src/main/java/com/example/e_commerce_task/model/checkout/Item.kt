package com.task.ecommerce.model.checkout

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item(
    @Json(name = "id") val id: String,
    @Json(name = "title") val title: String,
    @Json(name = "price") val price: String,
    @Json(name = "variations") val variations: String,
    @Json(name = "quantity") val quantity: String,
    @Json(name = "image") val image: String
)