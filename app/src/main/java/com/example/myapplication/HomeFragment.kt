package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var spinner: Spinner
    private lateinit var topStoriesTitle: TextView
    private lateinit var homeImageView: ImageView
    private lateinit var descriptionTextView: TextView
    private lateinit var imageGuenther: ImageView
    private lateinit var guentherFeatureTitle: TextView
    private lateinit var imageMassaAlonso: ImageView
    private lateinit var massaFeatureTitle: TextView
    private lateinit var imageNewey: ImageView
    private lateinit var neweyFeatureTitle: TextView



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spinner = view.findViewById(R.id.newsSpinner)
        topStoriesTitle = view.findViewById(R.id.topStoriesTitle)
        homeImageView = view.findViewById(R.id.home)
        descriptionTextView = view.findViewById(R.id.descriptionTextView)
        imageGuenther = view.findViewById(R.id.imageGuenther)
        guentherFeatureTitle = view.findViewById(R.id.guentherFeatureTitle)
        imageMassaAlonso = view.findViewById(R.id.imageMassaAlonso)
        massaFeatureTitle = view.findViewById(R.id.massaFeatureTitle)
        imageNewey = view.findViewById(R.id.imageNewey)
        neweyFeatureTitle = view.findViewById(R.id.neweyFeatureTitle)




        val categories = arrayOf("All", "Racing", "Drivers", "Teams", "Technical")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                filterNews(categories[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }


    }


    private fun filterNews(category: String) {
        val allViews = listOf(topStoriesTitle, homeImageView, descriptionTextView, imageGuenther, guentherFeatureTitle, imageMassaAlonso, massaFeatureTitle, imageNewey, neweyFeatureTitle)

        allViews.forEach { it.visibility = View.GONE }  // Hide everything initially

        if (category == "All") {
            allViews.forEach { it.visibility = View.VISIBLE} // Show all if "All" is selected
        } else {
            when (category) {
                "Racing" -> {
                    listOf(topStoriesTitle, homeImageView, descriptionTextView).forEach { it.visibility = View.VISIBLE }
                }
                "Drivers" -> {
                    listOf(topStoriesTitle, imageMassaAlonso, massaFeatureTitle).forEach { it.visibility = View.VISIBLE }
                }
                "Teams" -> {
                    listOf(topStoriesTitle, imageGuenther, guentherFeatureTitle).forEach { it.visibility = View.VISIBLE }
                }
                "Technical" -> {
                    listOf(topStoriesTitle, imageNewey, neweyFeatureTitle).forEach { it.visibility = View.VISIBLE }
                }
            }
        }
    }
}