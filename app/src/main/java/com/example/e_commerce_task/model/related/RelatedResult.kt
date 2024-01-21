package com.task.ecommerce.model.related

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RelatedResult(
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
    val image: String?,
    @Json(name = "is_favorite")
    val isFavorite: Boolean?,
    @Json(name = "price")
    val price: String?,
    @Json(name = "sold_out")
    val soldOut: Boolean?,
    @Json(name = "title")
    val title: String?,
)