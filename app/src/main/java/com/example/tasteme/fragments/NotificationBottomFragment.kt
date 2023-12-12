package com.example.tasteme.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasteme.R
import com.example.tasteme.adapter.MenuAdapter
import com.example.tasteme.adapter.NotificationAdapter
import com.example.tasteme.databinding.FragmentNotificationBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class NotificationBottomFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNotificationBottomBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBottomBinding.inflate(layoutInflater, container, false)
        binding.btnNotificationBack.setOnClickListener {
            dismiss()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val itemsFoodName = listOf(
            "Your order has been Canceled Successfully",
            "Order has been taken by the driver",
            "Congrats Your Order Placed"
        )
        val imagesFood = listOf(
            R.drawable.sademoji,
            R.drawable.truck,
            R.drawable.congratulation
        )
        binding.rvNotificationItems.layoutManager = LinearLayoutManager(requireContext())
        binding.rvNotificationItems.adapter =
            NotificationAdapter(ArrayList(itemsFoodName), ArrayList(imagesFood))
    }

}