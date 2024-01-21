package com.task.ecommerce.model.checkout

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreateOrderResult(
    @Json(name = "id") val id: Int,
    @Json(name = "payment") val payment: String,
    @Json(name = "sub_total") val subTotal: Int,
    @Json(name = "discount") val discount: Int,
    @Json(name = "delivery_fee") val deliveryFee: Int,
    @Json(name = "total_amount") val totalAmount: Int,
    @Json(name = "count_items") val countItems: Int,
    @Json(name = "items") val items: List<Item>,
    @Json(name = "address") val address: List<Any>,
    @Json(name = "date") val date: String,
    @Json(name = "time") val time: String,
    @Json(name = "title_status") val titleStatus: String,
    @Json(name = "address_id") val addressId: String,
    @Json(name = "is_delivery") val isDelivery: String,
    @Json(name = "status") val status: String
)