package com.example.tasteme.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasteme.R
import com.example.tasteme.adapter.CartAdapter
import com.example.tasteme.databinding.FragmentCartBinding


class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding

    val itemsFoodName = listOf(
        "Burger",
        "Sandwich",
        "Momo",
        "Chawmin",
        "Chicken Lolipop",
        "Vegetable Stir-Fry",
        "Chicken Curry",
        "Lobster Bisque"
    )
    val prices = listOf("$8", "$5", "$9", "$5", "$7", "$8", "$10", "$9")
    val imagesFood = listOf(
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu6,
        R.drawable.menu7,
        R.drawable.menu4
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentCartBinding.inflate(layoutInflater, container, false)

        //setup recyclerView
        binding.rvCard.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCard.adapter =
            CartAdapter(ArrayList(itemsFoodName), ArrayList(prices), ArrayList(imagesFood))

        return binding.root
    }
}