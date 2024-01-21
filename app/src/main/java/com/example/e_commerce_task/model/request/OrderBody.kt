package com.task.ecommerce.model.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OrderBody(
    @Json(name = "name") val name: String,
    @Json(name = "phone") val phone: String,
    @Json(name = "promocode_id") val promoCodeId: String,
    @Json(name = "payment") val payment: String,
    @Json(name = "address_id") val addressId: String,
    @Json(name = "re_order") val reOrder: String,
    @Json(name = "items") val items: List<Item>
)