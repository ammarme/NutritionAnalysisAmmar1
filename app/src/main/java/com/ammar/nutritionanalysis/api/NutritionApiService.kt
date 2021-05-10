package com.ammar.nutritionanalysis.api

import android.content.Context
import androidx.fragment.app.Fragment
import com.ammar.nutritionanalysis.model.nutritiondetails.NutritionDetailsResponse
import com.ammar.nutritionanalysis.model.recipe.RecipeBody
import com.google.gson.Gson
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface NutritionApiService {

    @POST("api/nutrition-details")
    suspend fun analyze(
        @Body recipe: RecipeBody,
    ): NutritionDetailsResponse
}

