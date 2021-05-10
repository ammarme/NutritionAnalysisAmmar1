package com.ammar.nutritionanalysis.model.recipe

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecipeBody(
    @SerializedName("ingr")
    val ingr: List<String>? = emptyList(),
    @SerializedName("prep")
    val prep: String? = "",
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("yield")
    val yield: String? = "",
) : Parcelable  