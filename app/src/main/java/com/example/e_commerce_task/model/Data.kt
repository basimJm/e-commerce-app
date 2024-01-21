package com.task.ecommerce.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "brand")
    val brand: List<Brand>? ,
    @Json(name = "brand_id")
    val brandId: Int?,
    @Json(name = "category")
    val category: String?,
    @Json(name = "category_id")
    val categoryId: Int?,
    @Json(name = "category_image")
    val categoryImage: List<CategoryImage>?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "is_favorite")
    val isFavorite: Boolean?,
    @Json(name = "items_id")
    val itemsId: Int?,
    @Json(name = "price")
    val price: Int?,
    @Json(name = "sold_out")
    val soldOut: Boolean?,
    @Json(name = "title")
    val title: String?
)