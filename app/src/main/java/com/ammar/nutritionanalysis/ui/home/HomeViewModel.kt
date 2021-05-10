package com.ammar.nutritionanalysis.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ammar.nutritionanalysis.model.nutritiondetails.NutritionDetailsResponse
import com.ammar.nutritionanalysis.model.recipe.RecipeBody
import com.ammar.nutritionanalysis.repository.MainRepository
import com.ammar.nutritionanalysis.utils.DataState
import com.ammar.nutritionanalysis.utils.launchCatching
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    ) : ViewModel() {
    private val _dataState: MutableLiveData<DataState<NutritionDetailsResponse>> = MutableLiveData()

    val dataState: LiveData<DataState<NutritionDetailsResponse>>
        get() = _dataState

    fun analyze(ingredients: String) {
        viewModelScope.launchCatching(
            onError = {
                _dataState.value = DataState.Error(it)
            }) {
            _dataState.value = DataState.Loading


            val ingredientsList = ingredients.lines()

            val response = mainRepository.analyze(RecipeBody(ingr = ingredientsList))

            _dataState.value = DataState.Success(response)

            // clears the data after opening summary screen.
            _dataState.value = null
        }
    }
}