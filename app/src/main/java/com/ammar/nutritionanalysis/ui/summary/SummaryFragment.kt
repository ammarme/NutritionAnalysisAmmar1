package com.ammar.nutritionanalysis.ui.summary

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ammar.nutritionanalysis.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_summary.*

@AndroidEntryPoint
class SummaryFragment : Fragment(R.layout.fragment_summary) {
    private val args: SummaryFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nutritionDetails = args.nutritionDetails

        nutritionRecyclerView.adapter =
            SummaryAdapter(nutritionDetails.totalNutrients.values.toMutableList())
    }
}