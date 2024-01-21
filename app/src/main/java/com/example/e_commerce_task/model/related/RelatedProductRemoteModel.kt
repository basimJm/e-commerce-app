package com.task.ecommerce.model.related

import com.task.ecommerce.model.Status
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RelatedProductRemoteModel(
    @Json(name = "status")
    val status: Status?,
    @Json(name = "results")
    val results: List<RelatedResult>?
)