package com.ammar.nutritionanalysis.api

import com.ammar.nutritionanalysis.APP_ID
import com.ammar.nutritionanalysis.APP_KEY
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url.newBuilder()
            .addQueryParameter(
                "app_id", APP_ID
            )
            .addQueryParameter(
                "app_key", APP_KEY
            )
            .build()

        return chain.proceed(
            chain.request()
                .newBuilder()
                .url(url)
                .build()
        )
    }

}