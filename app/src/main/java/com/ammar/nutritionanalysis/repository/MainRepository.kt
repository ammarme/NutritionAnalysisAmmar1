package com.ammar.nutritionanalysis.repository

import com.ammar.nutritionanalysis.api.NutritionApiService
import com.ammar.nutritionanalysis.model.nutritiondetails.NutritionDetailsResponse
import com.ammar.nutritionanalysis.model.recipe.RecipeBody

class MainRepository(
    private val nutritionApiService: NutritionApiService,
) : NutritionApiService {

    override suspend fun analyze(recipe: RecipeBody): NutritionDetailsResponse {
        return nutritionApiService.analyze(recipe)
    }
}