package com.example.e_commerce_task.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.ecommerce.data.repo.HomeRepository
import com.task.ecommerce.model.Result
import com.task.ecommerce.model.checkout.CreateOrderRemoteModel
import com.task.ecommerce.model.itemsinfo.ItemsResults
import com.task.ecommerce.model.related.RelatedProductRemoteModel
import com.task.ecommerce.model.request.OrderBody
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(private val homeRepository: HomeRepository) : ViewModel() {
    private val _success = MutableStateFlow<List<Result>?>(emptyList())
    val success: StateFlow<List<Result>?> = _success.asStateFlow()
    private val _successItemsById = MutableStateFlow<ItemsResults?>(null)
    val successItemsById: StateFlow<ItemsResults?> = _successItemsById.asStateFlow()
    private val _successRelatedProduct = MutableStateFlow<RelatedProductRemoteModel?>(null)
    val successRelatedProduct: StateFlow<RelatedProductRemoteModel?> = _successRelatedProduct.asStateFlow()
    private val _successCreateOrder = MutableStateFlow<CreateOrderRemoteModel?>(null)
    val successCreateOrder: StateFlow<CreateOrderRemoteModel?> = _successCreateOrder.asStateFlow()
    private val _loading = MutableStateFlow<Boolean>(false)
    val loading = _loading.asStateFlow()
    private val _error = MutableStateFlow<Exception?>(null)
    val error = _error.asStateFlow()

    fun getHome() {
        viewModelScope.launch {
            _loading.emit(true)
            try {
                val data = homeRepository.getHome()
                _success.emit(data)
            } catch (e: Exception) {
                _error.emit(e)
            }
            _loading.emit(false)
        }
    }

    fun getItemById(id: Int) {
        viewModelScope.launch {
            try {
                val data = homeRepository.getItemsById(id)
                _successItemsById.emit(data)
            } catch (e: Exception) {
            }
        }
    }

    fun getRelatedProduct(brandId: Int, page: Int) {
        viewModelScope.launch {
            try {
                val data = homeRepository.getRelatedProduct(brandId, page)
                _successRelatedProduct.emit(data)
            } catch (e: Exception) {
            }
        }
    }

    fun createOrder(body: OrderBody) {
        viewModelScope.launch {
            try {
                val data = homeRepository.createOrder(body)
                _successCreateOrder.emit(data)
            } catch (e: Exception) {
            }
        }
    }
}