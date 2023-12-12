package com.example.tasteme.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasteme.R
import com.example.tasteme.adapter.MenuAdapter
import com.example.tasteme.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    lateinit var binding: FragmentSearchBinding
    lateinit var mAdapter: MenuAdapter
    private val originalMenuFoodName = listOf(
        "Burger",
        "Sandwich",
        "Momo",
        "Chawmin",
        "Chicken Lolipop",
        "Vegetable Stir-Fry",
        "Chicken Curry",
        "Lobster Bisque"
    )
    private val originalMenuPrices = listOf("$8", "$5", "$9", "$5", "$7", "$8", "$10", "$9")
    private val originalMenuImages = listOf(
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu6,
        R.drawable.menu7,
        R.drawable.menu4
    )
    private val filterMenuName = mutableListOf<String>()
    private val filterMenuPrice = mutableListOf<String>()
    private val filterMenuImage = mutableListOf<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        mAdapter = MenuAdapter(
            filterMenuName,
            filterMenuPrice,
            filterMenuImage
        )
        binding.rvSearchItems.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSearchItems.adapter = mAdapter
        // show all menu items
        showAllMenu()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // setup searchView
        setupSearchView()
    }

    private fun showAllMenu() {
        filterMenuName.clear()
        filterMenuPrice.clear()
        filterMenuImage.clear()

        filterMenuName.addAll(originalMenuFoodName)
        filterMenuPrice.addAll(originalMenuPrices)
        filterMenuImage.addAll(originalMenuImages)

        mAdapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    filterMenuItems(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    filterMenuItems(newText)
                }
                return true
            }

        })
    }

    private fun filterMenuItems(query: String) {
        filterMenuName.clear()
        filterMenuPrice.clear()
        filterMenuImage.clear()

        originalMenuFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(query, ignoreCase = true)) {
                filterMenuName.add(foodName)
                filterMenuPrice.add(originalMenuPrices[index])
                filterMenuImage.add(originalMenuImages[index])
            }
        }
        mAdapter.notifyDataSetChanged()
    }
}