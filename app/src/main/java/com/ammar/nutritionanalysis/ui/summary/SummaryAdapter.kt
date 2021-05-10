package com.ammar.nutritionanalysis.ui.summary

import android.annotation.SuppressLint
import com.ammar.nutritionanalysis.R
import com.ammar.nutritionanalysis.model.nutritiondetails.NutrientItem
import com.ammar.nutritionanalysis.utils.BaseAdapter
import com.ammar.nutritionanalysis.utils.KBaseViewHolder
import kotlinx.android.synthetic.main.row_nutrient.*


class SummaryAdapter(items: List<NutrientItem>) :
    BaseAdapter<NutrientItem>(R.layout.row_nutrient, items) {

    @SuppressLint("SetTextI18n")
    override fun convert(holder: KBaseViewHolder, item: NutrientItem) {
        holder.apply {
            item.apply {
                labelTv.text = label

                ammountTv.text = "${String.format("%.3f", quantity)} $unit"
            }
        }
    }
}
