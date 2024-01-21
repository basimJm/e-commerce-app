package com.task.ecommerce.model.itemsinfo

import com.task.ecommerce.model.Status
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ItemsInfoRemoteModel(
    @Json(name = "results")
    val results: ItemsResults?,
    @Json(name = "status")
    val status: Status?
)