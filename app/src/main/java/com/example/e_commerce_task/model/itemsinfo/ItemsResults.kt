package com.task.ecommerce.model.itemsinfo

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ItemsResults(
    @Json(name = "brand_id")
    val brandId: Int?,
    @Json(name = "category")
    val category: String?,
    @Json(name = "category_id")
    val categoryId: Int?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "images")
    val image: List<Image>?,
    @Json(name = "is_favorite")
    val isFavorite: Boolean?,
    @Json(name = "price")
    val price: String?,
    @Json(name = "sold_out")
    val soldOut: Boolean?,
    @Json(name = "status")
    val status: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "variations")
    val variations: List<Variation>?
)