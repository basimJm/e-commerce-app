package com.task.ecommerce.data.datasource

import com.task.ecommerce.model.Result
import com.task.ecommerce.model.checkout.CreateOrderRemoteModel
import com.task.ecommerce.model.itemsinfo.ItemsResults
import com.task.ecommerce.model.related.RelatedProductRemoteModel
import com.task.ecommerce.model.request.OrderBody
import com.serjltt.moshi.adapters.Wrapped
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface ApiServices {
    @GET("/Api/get_home")
    @Wrapped(path = ["results"])
    suspend fun getHomeResult(@HeaderMap header: Map<String, String>): List<Result>?

    @POST("Api/get_items_by_id")
    @Wrapped(path = ["results"])
    suspend fun getItemsById(@HeaderMap header: Map<String, String>, @Body id: Map<String, Int>): ItemsResults?

    @POST("/Api/get_related_products")
    suspend fun getRelatedProduct(@HeaderMap header: Map<String, String>, @Body id: Map<String, Int>): RelatedProductRemoteModel?

    @POST("/Api/create_orders")
    suspend fun createOrder(@HeaderMap header: Map<String, String>, @Body body: OrderBody): CreateOrderRemoteModel?
}