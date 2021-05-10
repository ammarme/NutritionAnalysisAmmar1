package com.ammar.nutritionanalysis.model.nutritiondetails

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NutritionDetailsResponse(
    @SerializedName("calories")
    val calories: Int?,
    @SerializedName("cautions")
    val cautions: List<String>?,
    @SerializedName("dietLabels")
    val dietLabels: List<String>?,
    @SerializedName("healthLabels")
    val healthLabels: List<String>?,
    @SerializedName("totalNutrients")
    val totalNutrients: Map<String, NutrientItem>,
    @SerializedName("uri")
    val uri: String?,
    @SerializedName("yield")
    val yield: Double?
) : Parcelable  