package com.ammar.nutritionanalysis.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ammar.nutritionanalysis.R
import com.ammar.nutritionanalysis.model.nutritiondetails.NutritionDetailsResponse
import com.ammar.nutritionanalysis.utils.DataState
import com.ammar.nutritionanalysis.utils.setOnSingleClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        subscribeObservers()
    }

    private fun initViews() {
        // TODO: 5/11/2021 Just For testing
//        ingredientEt.setText(
//            "1 fresh ham, about 18 pounds\n 7 cloves garlic, minced\n 1 tablespoon caraway seeds, crushed\n 4 teaspoons salt\n Freshly ground pepper to taste\n 1 teaspoon olive oil\n 1 medium onion, peeled and chopped\n 3 cups sourdough rye bread, cut into 1/2-inch cubes\n 1 1/4 cups coarsely chopped pitted prunes\n 1 1/4 cups coarsely chopped dried apricots\n 1 large tart apple, peeled, cored and cut into 1/2-inch cubes\n 2 teaspoons chopped fresh rosemary\n 1 egg, lightly beaten\n 1 cup chicken broth, homemade or low-sodium canned"
//        )

        ingredientEt.doOnTextChanged { text, _, _, _ ->
            analyzeButton.isEnabled = !text.isNullOrBlank()
        }

        analyzeButton.setOnSingleClickListener {
            viewModel.analyze(ingredientEt.text.toString())
        }
    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(viewLifecycleOwner, { dataState ->
            when (dataState) {
                is DataState.Success<NutritionDetailsResponse> -> {
                    displayLoading(false)
                    openSummary(dataState.data)
                }
                is DataState.Loading -> {
                    displayLoading(true)
                }
                is DataState.Error -> {
                    displayLoading(false)
                    displayError(dataState.exception.message)
                }
            }
        })
    }

    private fun openSummary(data: NutritionDetailsResponse) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSummaryFragment(data))
    }

    private fun displayError(message: String?) {
        if (message != null) {
            Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(requireContext(), "Unknown error", Toast.LENGTH_LONG).show()
        }
    }

    private fun displayLoading(isLoading: Boolean) {
        progressBar.isVisible = isLoading
    }

}