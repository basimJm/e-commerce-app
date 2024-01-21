package com.task.ecommerce.data.repo

import com.task.ecommerce.core.provider.HeaderManager
import com.task.ecommerce.data.datasource.ApiServices
import com.task.ecommerce.model.Result
import com.task.ecommerce.model.checkout.CreateOrderRemoteModel
import com.task.ecommerce.model.itemsinfo.ItemsResults
import com.task.ecommerce.model.related.RelatedProductRemoteModel
import com.task.ecommerce.model.request.OrderBody
import javax.inject.Inject

class HomeRepository @Inject constructor(private val apiServices: ApiServices) {
    suspend fun getHome(): List<Result>? {
        val header = HeaderManager.getHeader()
        return apiServices.getHomeResult(header)
    }

    suspend fun getItemsById(id: Int): ItemsResults? {
        val header = HeaderManager.getHeader()
        val requestBody = mapOf("items_id" to id)
        return apiServices.getItemsById(header, requestBody)
    }

    suspend fun getRelatedProduct(brandId: Int, page: Int): RelatedProductRemoteModel? {
        val header = HeaderManager.getHeader()
        val requestBody = mapOf("brand_id" to brandId, "page" to page)
        return apiServices.getRelatedProduct(header, requestBody)
    }

    suspend fun createOrder(body: OrderBody): CreateOrderRemoteModel? {
        val header = HeaderManager.getHeader()
        return apiServices.createOrder(header, body)
    }
}