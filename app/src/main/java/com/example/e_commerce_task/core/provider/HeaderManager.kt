package com.task.ecommerce.core.provider

import com.task.ecommerce.core.constant.ApiHeaders
import com.task.ecommerce.core.constant.Constants.AUTHORIZATION_TOKEN
import com.task.ecommerce.core.constant.Constants.COOKIE
import com.task.ecommerce.core.constant.Constants.LANG

object HeaderManager {
    fun getHeader(): Map<String, String> {
        return mapOf(
            ApiHeaders.AUTHORIZATION to AUTHORIZATION_TOKEN,
            ApiHeaders.LANG to LANG, ApiHeaders.COOKIE to COOKIE
        )
    }
}